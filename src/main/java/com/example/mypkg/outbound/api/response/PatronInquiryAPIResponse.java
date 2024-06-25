/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.outbound.domain.resources.Book;
import com.example.mypkg.outbound.domain.resources.Patron;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronInquiryAPIResponse {

	@Valid
	@JsonProperty("patron")
	private Patron patron;

	@JsonProperty("borrowedBooks")
	private List<Book> borrowedBooks;

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
	 * @return the borrowedBooks
	 */
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	/**
	 * @param borrowedBooks the borrowedBooks to set
	 */
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	/**
	 * @param patron
	 * @param borrowedBooks
	 */
	public PatronInquiryAPIResponse(Patron patron, List<Book> borrowedBooks) {
		super();
		this.patron = patron;
		this.borrowedBooks = borrowedBooks;
	}

	/**
	 * 
	 */
	public PatronInquiryAPIResponse() {
		super();
	}

}
