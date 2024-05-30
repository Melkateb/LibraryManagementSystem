package com.example.mypkg.outbound.response;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Book;

@Validated
public class BooksListInquiryResponse {

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
	public BooksListInquiryResponse(List<Book> books) {
		super();
		this.books = books;
	}

	/**
	 * The default constructor
	 */
	public BooksListInquiryResponse() {
		super();
	}
}
