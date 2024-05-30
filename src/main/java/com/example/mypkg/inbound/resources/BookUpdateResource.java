/**
 * 
 */
package com.example.mypkg.inbound.resources;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.inbound.domain.resources.Book;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookUpdateResource {

	private String id;

	private Book book;

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
	 * @param id
	 * @param book
	 */
	public BookUpdateResource(String id, Book book) {
		super();
		this.id = id;
		this.book = book;
	}

	/**
	 * 
	 */
	public BookUpdateResource() {
		super();
	}

}
