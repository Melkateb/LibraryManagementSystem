/**
 * 
 */
package com.example.mypkg.inbound.resources;

import java.util.Date;

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
	@JsonProperty("mobile")
	private String mobile;

	@NotNull
	@JsonProperty("address")
	private String address;

	@NotNull
	@JsonProperty("email")
	private String email;

	@NotNull
	@JsonProperty("birthdate")
	private Date birthdate;

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
	 * @param name
	 * @param mobile
	 * @param address
	 * @param email
	 * @param birthdate
	 */
	public PatronCreateResource(@NotNull String name, @NotNull String mobile, @NotNull String address,
			@NotNull String email, @NotNull Date birthdate) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.birthdate = birthdate;
	}

	/**
	 * 
	 */
	public PatronCreateResource() {
		super();
	}

}
