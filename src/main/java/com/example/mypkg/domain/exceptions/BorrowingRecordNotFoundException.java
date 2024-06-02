/**
 * 
 */
package com.example.mypkg.domain.exceptions;

/**
 * @author MRKAT
 *
 */
public class BorrowingRecordNotFoundException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BorrowingRecordNotFoundException() {
		super(ErrorsEnum.BORROWING_RECORD_NOT_FOUND);
	}

}
