/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class PatronNotFoundException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public PatronNotFoundException() {
		super(ErrorsEnum.PATRON_NOT_FOUND);
	}

}
