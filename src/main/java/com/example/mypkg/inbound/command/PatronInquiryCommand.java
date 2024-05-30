/**
 * 
 */
package com.example.mypkg.inbound.command;

import org.springframework.validation.annotation.Validated;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronInquiryCommand {

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
	public PatronInquiryCommand(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public PatronInquiryCommand() {
		super();
	}

}
