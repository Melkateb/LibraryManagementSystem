/**
 * 
 */
package com.example.mypkg.outbound.response;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

/**
 * @author MRKAT
 *
 */
@Validated
public class BorrowingRecordCreateResponse {

	@NotBlank
	private String borrowingRecordId;

	/**
	 * @return the borrowingRecordId
	 */
	public String getBorrowingRecordId() {
		return borrowingRecordId;
	}

	/**
	 * @param borrowingRecordId the borrowingRecordId to set
	 */
	public void setBorrowingRecordId(String borrowingRecordId) {
		this.borrowingRecordId = borrowingRecordId;
	}

	/**
	 * @param borrowingRecordId
	 */
	public BorrowingRecordCreateResponse(@NotBlank String borrowingRecordId) {
		super();
		this.borrowingRecordId = borrowingRecordId;
	}

	/**
	 * 
	 */
	public BorrowingRecordCreateResponse() {
		super();
	}

}
