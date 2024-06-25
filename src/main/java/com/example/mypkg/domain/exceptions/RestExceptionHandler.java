/**
 * 
 */
package com.example.mypkg.domain.exceptions;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.mypkg.builders.ResponseMessage;
import com.example.mypkg.model.adapters.ResponseHeader;
import com.example.mypkg.model.adapters.ResponseStatus;
import com.example.mypkg.model.adapters.SubError;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author MRKAT
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Log4j2
@AllArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(null,
				ex.getBindingResult());
		return buildResponseEntity(getResponseMessageFromMethodNonValidtExpection(methodArgumentNotValidException));
	}

	@Override

	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus statusCode, WebRequest request) {
		return buildResponseEntity(getResponseMessagForGeneralException(ErrorsEnum.GENERAL_ERROR));
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		try {
			return buildResponseEntity(getResponseMessageFromMessageNotReadableException(ex));
		} catch (Exception e) {
			return buildResponseEntity(getResponseMessagForGeneralException(ErrorsEnum.GENERAL_ERROR));
		}
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(getResponseMessagForGeneralException(ErrorsEnum.MISSING_PARAM));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(getResponseMessageFromMethodNonValidtExpection(ex));
	}

	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(javax.validation.ConstraintViolationException ex,
			WebRequest request) {
		return buildResponseEntity(getResponseMessageFromConstraintExpection(ex));
	}

	@ExceptionHandler({ ApplicationException.class })
	protected ResponseEntity<Object> handleApplicationExceptions(ApplicationException ex, WebRequest request) {
		return buildResponseEntity(getResponseMessageFromAppExpection(ex));
	}

	@ExceptionHandler({ Exception.class, RuntimeException.class, NullPointerException.class })
	protected ResponseEntity<Object> handleGeneralException(Exception ex, HttpServletRequest request) {
		return buildResponseEntity(getResponseMessagForGeneralException(ErrorsEnum.GENERAL_ERROR));
	}

	ResponseMessage<?> getResponseMessageFromAppExpection(ApplicationException ex) {
		ResponseMessage<?> resp = new ResponseMessage<>();
		ResponseHeader respHeader = new ResponseHeader();
		ResponseStatus respStatus = new ResponseStatus();
		respStatus.setCode(ex.getErrorCode());
		respStatus.setDetails(ex.getDescription());
		respStatus.setHttpStatusCode(HttpStatus.valueOf(Integer.parseInt(ex.getHttpErrorCode().getHttpStatusCode())));
		respHeader.setStatus(respStatus);
		resp.setHeader(respHeader);
		return resp;
	}

	ResponseMessage<?> getResponseMessageFromConstraintExpection(javax.validation.ConstraintViolationException ex) {

		ResponseMessage<?> resp = new ResponseMessage<>();

		ResponseHeader respHeader = new ResponseHeader();

		ResponseStatus respStatus = new ResponseStatus();

		respStatus.setCode(ErrorsEnum.CONSTRAINT_VIOLATE.getErrorCode());
		respStatus.setHttpStatusCode(HttpStatus
				.valueOf(Integer.parseInt(ErrorsEnum.CONSTRAINT_VIOLATE.getHttpErrorCode().getHttpStatusCode())));

		if (ex.getConstraintViolations() != null) {
			ArrayList<SubError> subErrors = new ArrayList<>();
			for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
				SubError subError = new SubError();
				subError.setDetails(violation.getMessage());
				subError.setField(violation.getPropertyPath().toString());
				subErrors.add(subError);
			}
			respStatus.setSubErrors(subErrors);
		}

		respHeader.setStatus(respStatus);

		resp.setHeader(respHeader);
		return resp;
	}

	private ResponseMessage<?> getResponseMessageFromMessageNotReadableException(HttpMessageNotReadableException ex) {

		ResponseMessage<?> resp = new ResponseMessage<>();

		ResponseHeader respHeader = new ResponseHeader();

		ResponseStatus respStatus = new ResponseStatus();
		respStatus.setSubErrors(new ArrayList<>());

		respStatus.setCode(ErrorsEnum.CONSTRAINT_VIOLATE.getErrorCode());
		respStatus.setHttpStatusCode(HttpStatus
				.valueOf(Integer.parseInt(ErrorsEnum.CONSTRAINT_VIOLATE.getHttpErrorCode().getHttpStatusCode())));

		String field = null;
		String errorMessage = null;

		Throwable mostSpecificCause = ex.getMostSpecificCause();

		if (mostSpecificCause instanceof JsonMappingException) {
			JsonMappingException jsonMappingException = (JsonMappingException) mostSpecificCause;
			errorMessage = jsonMappingException.getMessage();
			field = extractJsonPath(jsonMappingException.getPath());

		} else if (mostSpecificCause instanceof DateTimeParseException) {
			field = "Invalid date/time format ";
			errorMessage = mostSpecificCause.getMessage();

		} else {
			throw ex;
		}

		if (field != null || errorMessage != null) {
			SubError subErorr = new SubError();
			subErorr.setField(field);
			subErorr.setDetails(errorMessage);
			respStatus.getSubErrors().add(subErorr);
		}

		respHeader.setStatus(respStatus);

		resp.setHeader(respHeader);
		return resp;
	}

	private String extractJsonPath(List<JsonMappingException.Reference> references) {
		List<String> pathItems = new ArrayList<>();
		for (JsonMappingException.Reference ref : references) {
			if (ref.getFieldName() != null) {
				pathItems.add(ref.getFieldName());
			} else if (ref.getIndex() >= 0) {
				pathItems.add("[" + ref.getIndex() + "]");
			}
		}
		return String.join(".", pathItems);
	}

	ResponseMessage<?> getResponseMessageFromMethodNonValidtExpection(MethodArgumentNotValidException ex) {

		ResponseMessage<?> resp = new ResponseMessage<>();

		ResponseHeader respHeader = new ResponseHeader();

		ResponseStatus respStatus = new ResponseStatus();

		respStatus.setCode(ErrorsEnum.CONSTRAINT_VIOLATE.getErrorCode());
		respStatus.setHttpStatusCode(HttpStatus
				.valueOf(Integer.parseInt(ErrorsEnum.CONSTRAINT_VIOLATE.getHttpErrorCode().getHttpStatusCode())));

		if (ex.getBindingResult() != null && ex.getBindingResult().getFieldErrors() != null) {

			ArrayList<SubError> subErorrs = new ArrayList<>();
			for (FieldError f : ex.getBindingResult().getFieldErrors()) {
				SubError subErorr = new SubError();
				subErorr.setField(f.getField());
				subErorr.setDetails(f.getDefaultMessage());
				subErorrs.add(subErorr);
			}
			for (ObjectError f : ex.getBindingResult().getGlobalErrors()) {
				SubError subErorr = new SubError();
				subErorr.setField(f.getObjectName());
				subErorr.setDetails(f.getDefaultMessage());
				subErorrs.add(subErorr);
			}
			respStatus.setSubErrors(subErorrs);
		}
		respHeader.setStatus(respStatus);

		resp.setHeader(respHeader);
		return resp;
	}

	ResponseMessage<?> getResponseMessagForGeneralException(ErrorsEnum e) {

		ResponseMessage<?> resp = new ResponseMessage<>();

		ResponseHeader respHeader = new ResponseHeader();
		ResponseStatus respStatus = new ResponseStatus();

		respStatus.setCode(e.getErrorCode());
		respStatus.setHttpStatusCode(HttpStatus.valueOf(Integer.parseInt(e.getHttpErrorCode().getHttpStatusCode())));
		respStatus.setDetails(e.getDescription());
		respHeader.setStatus(respStatus);

		resp.setHeader(respHeader);
		return resp;
	}

	private ResponseEntity<Object> buildResponseEntity(ResponseMessage<?> resp) {
		return new ResponseEntity<>(resp, resp.getHeader().getStatus().getHttpStatusCode());
	}

}