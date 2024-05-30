/**
 * 
 */
package com.example.mypkg.inbound.domain.resources;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class Patron {

	@JsonProperty("name")
	private String name;

	@JsonProperty("contactInformation")
	private String contactInformation;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the contactInformation
	 */
	public String getContactInformation() {
		return contactInformation;
	}

	/**
	 * @param contactInformation the contactInformation to set
	 */
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	/**
	 * @param name
	 * @param contactInformation
	 */
	public Patron(String name, String contactInformation) {
		super();
		this.name = name;
		this.contactInformation = contactInformation;
	}

	/**
	 * 
	 */
	public Patron() {
		super();
	}

}
