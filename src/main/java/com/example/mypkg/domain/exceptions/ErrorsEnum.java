package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public enum ErrorsEnum {

	GENERAL_ERROR("E0", HTTPStatusCodeEnum.INTERNAL_SERVER_ERROR, "General error"),
	CONSTRAINT_VIOLATE("E1", HTTPStatusCodeEnum.BAD_REQUEST, "Constraint violation"),
	MISSING_PARAM("E2", HTTPStatusCodeEnum.BAD_REQUEST, "Missing parameters"),
	BOOK_NOT_FOUND("E3", HTTPStatusCodeEnum.NOT_FOUND, "Book not found");

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
