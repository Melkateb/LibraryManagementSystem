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
public class BookRemoveCommand {

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
	public BookRemoveCommand(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public BookRemoveCommand() {
		super();
	}

}
