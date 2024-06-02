/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public enum HTTPStatusCodeEnum {

	OK("200"), BAD_REQUEST("400"), UNAUTHORIZED("401"), NOT_FOUND("404"), INTERNAL_SERVER_ERROR("500");

	private String httpStatusCode;

	/**
	 * @return the httpStatusCode
	 */
	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * @param httpStatusCode
	 */
	HTTPStatusCodeEnum(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

}
