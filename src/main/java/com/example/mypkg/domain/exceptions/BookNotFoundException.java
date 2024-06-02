/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class BookNotFoundException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super(ErrorsEnum.BOOK_NOT_FOUND);
	}

}
