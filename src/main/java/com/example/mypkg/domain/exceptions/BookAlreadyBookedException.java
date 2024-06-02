/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class BookAlreadyBookedException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BookAlreadyBookedException() {
		super(ErrorsEnum.BOOK_ALREADY_BOOKED);
	}

}
