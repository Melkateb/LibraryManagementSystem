/**
 * 
 */
package com.example.mypkg.outbound.response;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronInquiryResponse {

	private Patron patron;

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
	public PatronInquiryResponse(Patron patron, List<Book> borrowedBooks) {
		super();
		this.patron = patron;
		this.borrowedBooks = borrowedBooks;
	}

	/**
	 * 
	 */
	public PatronInquiryResponse() {
		super();
	}

}
