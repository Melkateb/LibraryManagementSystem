/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BookUpdateAPIResponse;
import com.example.mypkg.outbound.response.BookUpdateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BookUpdateAPIResponseBuilder extends APIResponseBuilder<BookUpdateResponse, BookUpdateAPIResponse> {

	@Override
	protected BookUpdateAPIResponse transformMessage(BookUpdateResponse serviceResponse) {
		return new BookUpdateAPIResponse();
	}

}
