/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.outbound.api.response.BorrowingRecordCreateAPIResponse;
import com.example.mypkg.outbound.domain.resources.BorrowingRecordCreateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BorrowingRecordCreateAPIResponseBuilder
		extends APIResponseBuilder<BorrowingRecordCreateResponse, BorrowingRecordCreateAPIResponse> {

	@Override
	protected BorrowingRecordCreateAPIResponse transformMessage(BorrowingRecordCreateResponse serviceResponse)
			throws AppException {
		return new BorrowingRecordCreateAPIResponse();
	}

}