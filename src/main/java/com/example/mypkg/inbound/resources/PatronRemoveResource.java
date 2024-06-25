/**
 * 
 */
package com.example.mypkg.inbound.resources;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.validators.Id;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronRemoveResource {

	@Id
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
	public PatronRemoveResource(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public PatronRemoveResource() {
		super();
	}

}
