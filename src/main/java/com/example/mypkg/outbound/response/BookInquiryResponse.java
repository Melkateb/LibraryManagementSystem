/**
 * 
 */
package com.example.mypkg.outbound.response;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookInquiryResponse {

	@JsonProperty("book")
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
