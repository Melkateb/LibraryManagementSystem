/**
 * 
 */
package com.example.mypkg.model.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author MRKAT
 *
 */
@JsonPropertyOrder({ "status" })
public class ResponseHeader {

	@JsonProperty("status")
	private ResponseStatus status;

	/**
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * @param status
	 */
	public ResponseHeader(ResponseStatus status) {
		super();
		this.status = status;
	}

	/**
	 * 
	 */
	public ResponseHeader() {
		super();
	}

}
