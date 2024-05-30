package com.example.mypkg.outbound.api.response;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.outbound.domain.resources.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BooksListInquiryAPIResponse {

	@JsonProperty("books")
	List<Book> books;

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @param books
	 */
	public BooksListInquiryAPIResponse(List<Book> books) {
		super();
		this.books = books;
	}

	/**
	 * The default constructor
	 */
	public BooksListInquiryAPIResponse() {
		super();
	}
}
