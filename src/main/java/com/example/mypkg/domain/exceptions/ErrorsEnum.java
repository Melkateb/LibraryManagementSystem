package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public enum ErrorsEnum {

	GENERAL_ERROR("E0", HTTPStatusCodeEnum.INTERNAL_SERVER_ERROR, "General error"),
	CONSTRAINT_VIOLATE("E1", HTTPStatusCodeEnum.BAD_REQUEST, "Constraint violation"),
	MISSING_PARAM("E2", HTTPStatusCodeEnum.BAD_REQUEST, "Missing parameters"),
	BOOK_NOT_FOUND("E3", HTTPStatusCodeEnum.NOT_FOUND, "Book not found"),
	BOOK_ALREADY_EXISTS("E4", HTTPStatusCodeEnum.BAD_REQUEST, "Book already exists"),
	PATRON_NOT_FOUND("E5", HTTPStatusCodeEnum.NOT_FOUND, "Patron not found"),
	PATRON_ALREADY_EXISTS("E6", HTTPStatusCodeEnum.BAD_REQUEST, "Patron already exists"),
	BOOK_ALREADY_BOOKED("E7", HTTPStatusCodeEnum.BAD_REQUEST, "Book already booked"),
	BORROWING_RECORD_NOT_FOUND("E8", HTTPStatusCodeEnum.NOT_FOUND, "Borrowing record not found"),
	BORROWING_RECORD_ALREADY_EXISTS("E9", HTTPStatusCodeEnum.BAD_REQUEST, "Borrowing record already exists");

	private String errorCode;
	private HTTPStatusCodeEnum httpErrorCode;
	private String description;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the httpErrorCode
	 */
	public HTTPStatusCodeEnum getHttpErrorCode() {
		return httpErrorCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param errorCode
	 * @param httpErrorCode
	 * @param description
	 */
	ErrorsEnum(String errorCode, HTTPStatusCodeEnum httpErrorCode, String description) {
		this.errorCode = errorCode;
		this.httpErrorCode = httpErrorCode;
		this.description = description;
	}

}
