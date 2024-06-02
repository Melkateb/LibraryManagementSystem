/**
 * 
 */
package com.example.mypkg.outbound.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.BooksListInquiryAPIResponse;
import com.example.mypkg.outbound.domain.resources.Book;
import com.example.mypkg.outbound.response.BooksListInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class BooksListInquiryAPIResponseBuilder
		extends APIResponseBuilder<BooksListInquiryResponse, BooksListInquiryAPIResponse> {

	@Override
	protected BooksListInquiryAPIResponse transformMessage(BooksListInquiryResponse serviceResponse) {
		List<Book> books = new ArrayList<Book>();
		for (com.example.mypkg.domain.model.Book book : serviceResponse.getBooks()) {
			Book newBook = new Book(book);
			books.add(newBook);
		}
		return new BooksListInquiryAPIResponse(books);
	}

}
