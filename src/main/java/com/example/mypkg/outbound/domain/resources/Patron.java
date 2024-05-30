/**
 * 
 */
package com.example.mypkg.outbound.domain.resources;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;

/**
 * @author MRKAT
 *
 */
@Validated
public class Patron {

	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("contactInformation")
	private String contactInformation;

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
	 * @param id
	 * @param name
	 * @param contactInformation
	 */
	public Patron(String id, String name, String contactInformation) {
		super();
		this.id = id;
		this.name = name;
		this.contactInformation = contactInformation;
	}

	/**
	 * 
	 */
	public Patron() {
		super();
	}

	/**
	 * @param book
	 */
	public Patron(com.example.mypkg.domain.model.Patron patron) {
		super();
		this.id = patron.getId();
		this.name = patron.getName();
		this.contactInformation = patron.getContactInformation();
	}
}
