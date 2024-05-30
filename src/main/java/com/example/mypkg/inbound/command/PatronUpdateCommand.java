/**
 * 
 */
package com.example.mypkg.inbound.command;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.inbound.domain.resources.Patron;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronUpdateCommand {

	private String id;

	private Patron patron;

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
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	/**
	 * @param id
	 * @param patron
	 */
	public PatronUpdateCommand(String id, Patron patron) {
		super();
		this.id = id;
		this.patron = patron;
	}

	/**
	 * 
	 */
	public PatronUpdateCommand() {
		super();
	}

}
