/**
 * 
 */
package com.example.mypkg.builders;

import com.example.mypkg.model.adapters.ResponseHeader;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author MRKAT
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "header", "data" })
public class ResponseMessage<T> {

	@JsonProperty("data")
	T data;

	@JsonProperty("header")
	private ResponseHeader header;

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
	 * @return the header
	 */
	public ResponseHeader getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(ResponseHeader header) {
		this.header = header;
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
