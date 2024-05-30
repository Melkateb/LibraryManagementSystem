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
public class BookCreateResponse {

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
	public BookCreateResponse(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public BookCreateResponse() {
		super();
	}

}
