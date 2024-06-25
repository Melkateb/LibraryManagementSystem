/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.mypkg.utils.FlagConverter;

/**
 * @author MRKAT
 *
 */

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PUBLICATION_YEAR")
	private Date publicationYear;

	@Column(name = "ISBN")
	private String isbn;

	@Convert(converter = FlagConverter.class)
	@Column(name = "IS_BORROWED")
	private Boolean isBorrowed = false;

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
	 * @return the isBorrowed
	 */
	public Boolean getIsBorrowed() {
		return isBorrowed;
	}

	/**
	 * @param isBorrowed the isBorrowed to set
	 */
	public void setIsBorrowed(Boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public Book() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, isbn, publicationYear, title, isBorrowed);
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
				&& Objects.equals(publicationYear, other.publicationYear) && Objects.equals(title, other.title)
				&& Objects.equals(isBorrowed, other.isBorrowed);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
				+ ", isbn=" + isbn + ", isBorrowed=" + isBorrowed + "]";
	}

}
