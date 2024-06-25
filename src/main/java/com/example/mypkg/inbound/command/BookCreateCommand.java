/**
 * 
 */
package com.example.mypkg.inbound.command;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.validators.ISBN;
import com.example.mypkg.domain.validators.Name;
import com.example.mypkg.domain.validators.Title;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookCreateCommand {

	@Title
	private String title;

	@Name
	private String author;

	private Date publicationYear;

	@ISBN
	private String isbn;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publicationYear
	 */
	public Date getPublicationYear() {
		return publicationYear;
	}

	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(Date publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @param title
	 * @param author
	 * @param publicationYear
	 * @param isbn
	 */
	public BookCreateCommand(String title, String author, Date publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	/**
	 * 
	 */
	public BookCreateCommand() {
		super();
	}

}
