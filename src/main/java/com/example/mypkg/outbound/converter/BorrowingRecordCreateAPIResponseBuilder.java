/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BorrowingRecordCreateAPIResponse;
import com.example.mypkg.outbound.response.BorrowingRecordCreateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BorrowingRecordCreateAPIResponseBuilder
		extends APIResponseBuilder<BorrowingRecordCreateResponse, BorrowingRecordCreateAPIResponse> {

	@Override
	protected BorrowingRecordCreateAPIResponse transformMessage(BorrowingRecordCreateResponse serviceResponse) {
		return new BorrowingRecordCreateAPIResponse(serviceResponse.getBorrowingRecordId());
	}

}
