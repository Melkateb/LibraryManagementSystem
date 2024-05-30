/**
 * 
 */
package com.example.mypkg.inbound.resources;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BookCreateResource {

	@NotNull
	@JsonProperty("title")
	private String title;

	@NotNull
	@JsonProperty("author")
	private String author;

	@NotNull
	@JsonProperty("publicationYear")
	private Date publicationYear;

	@NotNull
	@JsonProperty("isbn")
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
	public BookCreateResource(@NotNull String title, @NotNull String author, @NotNull Date publicationYear,
			@NotNull String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	/**
	 * 
	 */
	public BookCreateResource() {
		super();
	}

}
