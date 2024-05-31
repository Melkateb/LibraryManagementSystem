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
public class BorrowingRecordUpdateCommand {

	private String bookId;

	private String patronId;

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the patronId
	 */
	public String getPatronId() {
		return patronId;
	}

	/**
	 * @param patronId the patronId to set
	 */
	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	/**
	 * @param bookId
	 * @param patronId
	 */
	public BorrowingRecordUpdateCommand(String bookId, String patronId) {
		super();
		this.bookId = bookId;
		this.patronId = patronId;
	}

	/**
	 * 
	 */
	public BorrowingRecordUpdateCommand() {
		super();
	}

}
