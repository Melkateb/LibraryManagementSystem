/**
 * 
 */
package com.example.mypkg.builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author MRKAT
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "date" })
public class ResponseMessage<T> {

	@JsonProperty("data")
	T data;

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 
	 */
	public ResponseMessage() {
		super();
	}

	/**
	 * @param data
	 */
	public ResponseMessage(T data) {
		super();
		this.data = data;
	}

}
