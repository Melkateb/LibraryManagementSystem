/**
 * 
 */
package com.example.mypkg.outbound.response;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

/**
 * @author MRKAT
 *
 */
@Validated
public class BorrowingRecordUpdateResponse {

	private Date borrowingDate;

	private Date returnDate;

	/**
	 * @return the borrowingDate
	 */
	public Date getBorrowingDate() {
		return borrowingDate;
	}

	/**
	 * @param borrowingDate the borrowingDate to set
	 */
	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
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

	/**
	 * @param borrowingDate
	 * @param returnDate
	 */
	public BorrowingRecordUpdateResponse(Date borrowingDate, Date returnDate) {
		super();
		this.borrowingDate = borrowingDate;
		this.returnDate = returnDate;
	}

	/**
	 * 
	 */
	public BorrowingRecordUpdateResponse() {
		super();
	}

}
