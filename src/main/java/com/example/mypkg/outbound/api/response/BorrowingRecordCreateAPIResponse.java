/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class BorrowingRecordCreateAPIResponse {

	@NotBlank
	@JsonProperty("borrowingRecordId")
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
	public BorrowingRecordCreateAPIResponse(@NotBlank String borrowingRecordId) {
		super();
		this.borrowingRecordId = borrowingRecordId;
	}

	/**
	 * 
	 */
	public BorrowingRecordCreateAPIResponse() {
		super();
	}

}
