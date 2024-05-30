/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.outbound.domain.resources.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookInquiryAPIResponse {

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
	public BookInquiryAPIResponse(Book book) {
		super();
		this.book = book;
	}

	/**
	 * 
	 */
	public BookInquiryAPIResponse() {
		super();
	}

}
