/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class PatronAlreadyExistsException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public PatronAlreadyExistsException() {
		super(ErrorsEnum.PATRON_ALREADY_EXISTS);
	}

}