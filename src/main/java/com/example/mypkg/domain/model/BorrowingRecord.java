/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */
@Entity
@Table(name = "BORROWING_RECORD")
public class BorrowingRecord {
	
	@Column(name = "ID", unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "BOOK_ID")
	private String bookId;
	
	@Column(name = "PATRON_ID")
	private String patronId;

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
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the patronId
	 */
	public String getPatronId() {
		return patronId;
	}

	/**
	 * @param patronId the patronId to set
	 */
	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public BorrowingRecord() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, id, patronId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowingRecord other = (BorrowingRecord) obj;
		return Objects.equals(bookId, other.bookId) && Objects.equals(id, other.id)
				&& Objects.equals(patronId, other.patronId);
	}

	@Override
	public String toString() {
		return "BorrowingRecord [id=" + id + ", bookId=" + bookId + ", patronId=" + patronId + "]";
	}
		
}
