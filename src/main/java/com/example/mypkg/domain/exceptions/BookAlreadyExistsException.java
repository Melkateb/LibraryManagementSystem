/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class BookAlreadyExistsException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BookAlreadyExistsException() {
		super(ErrorsEnum.BOOK_ALREADY_EXISTS);
	}

}
