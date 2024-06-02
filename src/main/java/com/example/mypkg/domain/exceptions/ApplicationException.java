/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public abstract class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private HTTPStatusCodeEnum httpErrorCode;
	private String description;
	protected Object data;

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
	 * // * @return the description //
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @param error
	 */
	public ApplicationException(ErrorsEnum error) {
		super();
		this.errorCode = error.getErrorCode();
		this.httpErrorCode = error.getHttpErrorCode();
		this.description = error.getDescription();
	}

	/**
	 * @param errorCode
	 * @param httpErrorCode
	 * @param description
	 * @param data
	 */
	public ApplicationException(String errorCode, HTTPStatusCodeEnum httpErrorCode, String description, Object data) {
		super();
		this.errorCode = errorCode;
		this.httpErrorCode = httpErrorCode;
		this.description = description;
		this.data = data;
	}

	/**
	 * @param errorCode
	 * @param httpErrorCode
	 * @param description
	 */
	public ApplicationException(String errorCode, HTTPStatusCodeEnum httpErrorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.httpErrorCode = httpErrorCode;
		this.description = description;
	}

}
