/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.validators.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronCreateAPIResponse {

	@Id
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
	public PatronCreateAPIResponse(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public PatronCreateAPIResponse() {
		super();
	}

}
