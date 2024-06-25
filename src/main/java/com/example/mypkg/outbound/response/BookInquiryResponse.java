/**
 * 
 */
package com.example.mypkg.outbound.response;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Book;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookInquiryResponse {

	@Valid
	private Book book;

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @param book
	 */
	public BookInquiryResponse(Book book) {
		super();
		this.book = book;
	}

	/**
	 * 
	 */
	public BookInquiryResponse() {
		super();
	}

}
