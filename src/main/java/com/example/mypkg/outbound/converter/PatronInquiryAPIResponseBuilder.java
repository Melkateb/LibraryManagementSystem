/**
 * 
 */
package com.example.mypkg.outbound.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.PatronInquiryAPIResponse;
import com.example.mypkg.outbound.domain.resources.Book;
import com.example.mypkg.outbound.domain.resources.Patron;
import com.example.mypkg.outbound.response.PatronInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronInquiryAPIResponseBuilder
		extends APIResponseBuilder<PatronInquiryResponse, PatronInquiryAPIResponse> {

	@Override
	protected PatronInquiryAPIResponse transformMessage(PatronInquiryResponse serviceResponse) {

		List<Book> borrowedBooks = new ArrayList<Book>();
		for (com.example.mypkg.domain.model.Book b : serviceResponse.getBorrowedBooks()) {
			Book book = new Book(b);
			borrowedBooks.add(book);
		}
		return new PatronInquiryAPIResponse(new Patron(serviceResponse.getPatron()), borrowedBooks);
	}

}
