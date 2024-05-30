/**
 * 
 */
package com.example.mypkg.outbound.response;

import org.springframework.validation.annotation.Validated;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronCreateResponse {

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
	public PatronCreateResponse(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public PatronCreateResponse() {
		super();
	}

}
