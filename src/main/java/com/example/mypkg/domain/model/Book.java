/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */

@Entity
@Table(name = "BOOK")
public class Book {

	@Column(name = "ID", unique = true)
	private String id;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PUBLICATION_YEAR")
	private String publicationYear;
	
	@Column(name = "ISBN")
	private String isbn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, isbn, publicationYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(publicationYear, other.publicationYear) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
				+ ", isbn=" + isbn + "]";
	}
	
	
}
