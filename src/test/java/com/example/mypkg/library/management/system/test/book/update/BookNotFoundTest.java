/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.update;

import java.util.Date;
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
import com.example.mypkg.outbound.api.response.BookUpdateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class BookNotFoundTest
		extends GenericAPITest<com.example.mypkg.inbound.domain.resources.Book, BookUpdateAPIResponse> {

	@Value("${bookUpdate.url}")
	private String URL;

	private String BOOK_ID = UUID.randomUUID().toString();
	private String NEW_AUTHOR = "New author";
	private String NEW_TITLE = "New title";
	private Date PUBLICATION_YEAR = new Date();
	private String NEW_ISBN = "0-596-52068-9";

	@InjectMocks
	private BooksManageController booksManageController;

	@Autowired
	BookRepository bookRepository;

	@Override
	protected void initializeDataBase() throws Exception {

	}

	@Override
	protected com.example.mypkg.inbound.domain.resources.Book createRequest() throws Exception {
		return new com.example.mypkg.inbound.domain.resources.Book(NEW_TITLE, NEW_AUTHOR, null, NEW_ISBN, false);
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.PUT;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, BOOK_ID);
	}

	@Override
	protected void assertResults(BookUpdateAPIResponse response) throws Exception {
		assertFailure(BookNotFoundException.class);
	}

}
