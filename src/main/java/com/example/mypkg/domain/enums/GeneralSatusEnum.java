/**
 * 
 */
package com.example.mypkg.domain.enums;

import com.example.mypkg.domain.exceptions.HTTPStatusCodeEnum;

/**
 * @author MRKAT
 *
 */
public enum GeneralSatusEnum {

	GENERAL_ERROR("E1", HTTPStatusCodeEnum.BAD_REQUEST), SUCCESS("S0", HTTPStatusCodeEnum.OK);

	private String errorCode;
	private HTTPStatusCodeEnum httpStatusCode;

	/**
	 * @param errorCode
	 * @param httpStatusCode
	 */
	GeneralSatusEnum(String errorCode, HTTPStatusCodeEnum httpStatusCode) {
		this.errorCode = errorCode;
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the httpStatusCode
	 */
	public HTTPStatusCodeEnum getHttpStatusCode() {
		return httpStatusCode;
	}

}
