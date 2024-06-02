/**
 * 
 */
package com.example.mypkg.model.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author MRKAT
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "details", "subErrors" })
public class ResponseStatus {

	@JsonProperty("code")
	private String code;

	@JsonProperty("details")
	private String details;

	@JsonIgnore
	private HttpStatus httpStatusCode;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("subErrors")
	private List<SubError> subErrors = new ArrayList<SubError>();

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the httpStatusCode
	 */
	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @param httpStatusCode the httpStatusCode to set
	 */
	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * @return the additionalProperties
	 */
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	/**
	 * @param additionalProperties the additionalProperties to set
	 */
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	/**
	 * @return the subErrors
	 */
	public List<SubError> getSubErrors() {
		return subErrors;
	}

	/**
	 * @param subErrors the subErrors to set
	 */
	public void setSubErrors(List<SubError> subErrors) {
		this.subErrors = subErrors;
	}

	/**
	 * 
	 */
	public ResponseStatus withStatusDesc(String statusDesc) {
		this.details = statusDesc;
		return this;
	}

	/**
	 * 
	 */
	public ResponseStatus withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	/**
	 * 
	 */
	public ResponseStatus() {
		super();
	}

}
