/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BookInquiryAPIResponse;
import com.example.mypkg.outbound.domain.resources.Book;
import com.example.mypkg.outbound.response.BookInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BookInquiryAPIResponseBuilder extends APIResponseBuilder<BookInquiryResponse, BookInquiryAPIResponse> {

	@Override
	protected BookInquiryAPIResponse transformMessage(BookInquiryResponse serviceResponse) {
		return new BookInquiryAPIResponse(new Book(serviceResponse.getBook()));
	}

}
