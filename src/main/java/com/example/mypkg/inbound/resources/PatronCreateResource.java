/**
 * 
 */
package com.example.mypkg.inbound.resources;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronCreateResource {

	@NotNull
	@JsonProperty("name")
	private String name;

	@NotNull
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
	public PatronCreateResource(@NotNull String name, @NotNull String contactInformation) {
		super();
		this.name = name;
		this.contactInformation = contactInformation;
	}

	/**
	 * 
	 */
	public PatronCreateResource() {
		super();
	}

}
