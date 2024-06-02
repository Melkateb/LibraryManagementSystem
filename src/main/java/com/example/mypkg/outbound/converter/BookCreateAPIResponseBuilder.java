/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BookCreateAPIResponse;
import com.example.mypkg.outbound.response.BookCreateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BookCreateAPIResponseBuilder extends APIResponseBuilder<BookCreateResponse, BookCreateAPIResponse> {

	@Override
	protected BookCreateAPIResponse transformMessage(BookCreateResponse serviceResponse) {
		return new BookCreateAPIResponse(serviceResponse.getId());
	}

}
