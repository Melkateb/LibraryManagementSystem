/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class BorrowingRecordAlreadyExistsException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BorrowingRecordAlreadyExistsException() {
		super(ErrorsEnum.BORROWING_RECORD_ALREADY_EXISTS);
	}

}