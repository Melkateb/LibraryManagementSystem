/**
 * 
 */
package com.example.mypkg.builders;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.enums.GeneralSatusEnum;
import com.example.mypkg.model.adapters.ResponseHeader;
import com.example.mypkg.model.adapters.ResponseStatus;

/**
 * @author MRKAT
 *
 */
@Service
public class ResponseBuilder {

	public <T> ResponseMessage<T> buildResponse(Object serviceResponse, String requestId) {

		ResponseMessage<T> finalResponse = new ResponseMessage<T>();
		ResponseHeader header = new ResponseHeader();
		ResponseStatus status = new ResponseStatus();

		if (serviceResponse == null
				|| (serviceResponse.getClass().equals(java.lang.Boolean.class) && serviceResponse.equals(false))) {
			status.setCode(GeneralSatusEnum.GENERAL_ERROR.getErrorCode());
		} else {
			status.setCode(GeneralSatusEnum.SUCCESS.getErrorCode());
		}

		header.setStatus(status);
		finalResponse.setHeader(header);

		return finalResponse;

	}

	public <T> ResponseMessage<T> buildResponse(Object serviceResponse) {

		ResponseMessage<T> finalResponse = new ResponseMessage<T>();
		ResponseHeader header = new ResponseHeader();
		ResponseStatus status = new ResponseStatus();

		if (serviceResponse == null
				|| (serviceResponse.getClass().equals(java.lang.Boolean.class) && serviceResponse.equals(false))) {
			status.setCode(GeneralSatusEnum.GENERAL_ERROR.getErrorCode());
		} else {
			status.setCode(GeneralSatusEnum.SUCCESS.getErrorCode());
		}

		header.setStatus(status);
		finalResponse.setHeader(header);

		return finalResponse;

	}
}
