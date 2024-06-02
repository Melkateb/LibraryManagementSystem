/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BorrowingRecordUpdateAPIResponse;
import com.example.mypkg.outbound.response.BorrowingRecordUpdateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BorrowingRecordUpdateAPIResponseBuilder
		extends APIResponseBuilder<BorrowingRecordUpdateResponse, BorrowingRecordUpdateAPIResponse> {

	@Override
	protected BorrowingRecordUpdateAPIResponse transformMessage(BorrowingRecordUpdateResponse serviceResponse) {
		return new BorrowingRecordUpdateAPIResponse(serviceResponse.getBorrowingDate(),
				serviceResponse.getReturnDate());
	}

}
