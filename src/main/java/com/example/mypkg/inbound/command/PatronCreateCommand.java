/**
 * 
 */
package com.example.mypkg.inbound.command;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.validators.Address;
import com.example.mypkg.domain.validators.Mobile;
import com.example.mypkg.domain.validators.Name;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronCreateCommand {

	@Name
	@NotNull
	private String name;

	@Mobile
	@NotNull
	private String mobile;

	@Address
	@NotNull
	private String address;

	@Email
	@NotNull
	private String email;

	@NotNull
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
	public PatronCreateCommand(@NotNull String name, @NotNull String mobile, @NotNull String address,
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
	public PatronCreateCommand() {
		super();
	}

}
