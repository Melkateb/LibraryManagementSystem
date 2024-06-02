/**
 * 
 */
package com.example.mypkg.outbound.domain.resources;

import java.util.Date;

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

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("address")
	private String address;

	@JsonProperty("email")
	private String email;

	@JsonProperty("birthdate")
	private Date birthdate;

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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @param id
	 * @param name
	 * @param mobile
	 * @param address
	 * @param email
	 * @param birthdate
	 */
	public Patron(String id, String name, String mobile, String address, String email, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.birthdate = birthdate;
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
		this.mobile = patron.getMobile();
		this.address = patron.getAddress();
		this.email = patron.getEmail();
		this.birthdate = patron.getBirthdate();
	}
}
