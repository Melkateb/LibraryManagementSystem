/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */
@Entity
@Table(name = "BORROWING_RECORD")
public class BorrowingRecord {

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "BOOK_ID")
	private String bookId;

	@Column(name = "PATRON_ID")
	private String patronId;

	@Column(name = "BORROW_DATE")
	private Date borrowDate;

	@Column(name = "RETURN_DATE")
	private Date returnDate;

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

	/**
	 * @return the borrowDate
	 */
	public Date getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate the borrowDate to set
	 */
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public BorrowingRecord() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, borrowDate, id, patronId, returnDate);
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
		return Objects.equals(bookId, other.bookId) && Objects.equals(borrowDate, other.borrowDate)
				&& Objects.equals(id, other.id) && Objects.equals(patronId, other.patronId)
				&& Objects.equals(returnDate, other.returnDate);
	}

	@Override
	public String toString() {
		return "BorrowingRecord [id=" + id + ", bookId=" + bookId + ", patronId=" + patronId + ", borrowDate="
				+ borrowDate + ", returnDate=" + returnDate + "]";
	}

}
