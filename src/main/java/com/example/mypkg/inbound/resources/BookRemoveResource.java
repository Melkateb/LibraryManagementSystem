/**
 * 
 */
package com.example.mypkg.inbound.resources;

import org.springframework.validation.annotation.Validated;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookRemoveResource {

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
	public BookRemoveResource(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public BookRemoveResource() {
		super();
	}

}
