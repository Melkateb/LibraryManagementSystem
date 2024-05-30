/**
 * 
 */
package com.example.mypkg.inbound.command;

/**
 * @author MRKAT
 *
 */
public class BookInquiryCommand {

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
	public BookInquiryCommand(String id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public BookInquiryCommand() {
		super();
	}

}
