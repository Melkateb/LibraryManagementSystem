/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.outbound.api.response.BookRemoveAPIResponse;
import com.example.mypkg.outbound.response.BookRemoveResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BookRemoveAPIResponseBuilder extends APIResponseBuilder<BookRemoveResponse, BookRemoveAPIResponse> {

	@Override
	protected BookRemoveAPIResponse transformMessage(BookRemoveResponse serviceResponse) throws AppException {
		return new BookRemoveAPIResponse();
	}

}
