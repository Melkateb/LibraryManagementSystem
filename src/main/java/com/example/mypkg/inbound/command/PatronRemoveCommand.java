/**
 * 
 */
package com.example.mypkg.inbound.command;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.validators.Id;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronRemoveCommand {

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
	public PatronRemoveCommand(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public PatronRemoveCommand() {
		super();
	}

}
