/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.inquiry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BooksManageController;
import com.example.mypkg.domain.model.Book;
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
public class HappyScenarioTest extends GenericAPITest<BookInquiryResource, BookInquiryAPIResponse> {

	@Value("${bookInquiry.url}")
	private String URL;

	private String BOOK_ID;
	private String AUTHOR = "Author";
	private String TITLE = "Title";
	private Date PUBLICATION_YEAR = new Date();
	private String ISBN = "1112221";

	@InjectMocks
	private BooksManageController booksManageController;

	@Autowired
	BookRepository bookRepository;

	@Override
	protected void initializeDataBase() throws Exception {

		Book book = new Book();
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);
		book.setPublicationYear(PUBLICATION_YEAR);
		book.setIsbn(ISBN);
		book.setIsBorrowed(true);
		bookRepository.save(book);

		BOOK_ID = book.getId();

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
		assertSuccess();
		assertEquals(response.getBook().getId(), BOOK_ID);
		assertEquals(response.getBook().getAuthor(), AUTHOR);
		assertEquals(response.getBook().getTitle(), TITLE);
		assertEquals(response.getBook().getIsbn(), ISBN);
		assertTrue(response.getBook().getIsBorrowed());
		assertEquals(response.getBook().getPublicationYear(), PUBLICATION_YEAR);
	}

}
