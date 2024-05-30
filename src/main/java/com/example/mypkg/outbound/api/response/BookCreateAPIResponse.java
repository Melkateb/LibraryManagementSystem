/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookCreateAPIResponse {

	@NotNull
	@JsonProperty("id")
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id
	 */
	public BookCreateAPIResponse(@NotNull String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public BookCreateAPIResponse() {
		super();
	}

}
