/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.inquiry;

import java.util.UUID;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BooksManageController;
import com.example.mypkg.domain.exceptions.BookNotFoundException;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.inbound.resources.BookInquiryResource;
import com.example.mypkg.outbound.api.response.BookInquiryAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class BookNotFoundTest extends GenericAPITest<BookInquiryResource, BookInquiryAPIResponse> {

	@Value("${bookInquiry.url}")
	private String URL;

	private String BOOK_ID = UUID.randomUUID().toString();

	@InjectMocks
	private BooksManageController booksManageController;

	@Autowired
	BookRepository bookRepository;

	@Override
	protected void initializeDataBase() throws Exception {

	}

	@Override
	protected BookInquiryResource createRequest() throws Exception {
		return new BookInquiryResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.GET;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, BOOK_ID);
	}

	@Override
	protected void assertResults(BookInquiryAPIResponse response) throws Exception {
		assertFailure(BookNotFoundException.class);
	}

}
