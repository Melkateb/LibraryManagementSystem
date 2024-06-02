/**
 * 
 */
package com.example.mypkg.model.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
public class SubError {

	@JsonProperty("code")
	private String field;

	@JsonProperty("details")
	private String details;

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
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
	 * @param field
	 * @param details
	 */
	public SubError(String field, String details) {
		super();
		this.field = field;
		this.details = details;
	}

	/**
	 * 
	 */
	public SubError() {
		super();
	}

}
