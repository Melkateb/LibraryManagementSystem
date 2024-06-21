/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.list.inquiry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.example.mypkg.inbound.resources.BooksListInquiryResource;
import com.example.mypkg.outbound.api.response.BooksListInquiryAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<BooksListInquiryResource, BooksListInquiryAPIResponse> {

	@Value("${bookListInquiry.url}")
	private String URL;

	private String FIRST_BOOK_ID;
	private String SECOND_BOOK_ID;
	private String FIRST_AUTHOR = "Author 1";
	private String SECOND_AUTHOR = "Author 2";
	private String FIRST_TITLE = "Title 1";
	private String SECOND_TITLE = "Title 2";
	private Date PUBLICATION_YEAR = new Date();
	private String FIRST_ISBN = "1112221";
	private String SECOND_ISBN = "1112222";

	@InjectMocks
	private BooksManageController booksManageController;

	@Autowired
	BookRepository bookRepository;

	@Override
	protected void initializeDataBase() throws Exception {

		Book firstBook = new Book();
		firstBook.setAuthor(FIRST_AUTHOR);
		firstBook.setTitle(FIRST_TITLE);
		firstBook.setPublicationYear(PUBLICATION_YEAR);
		firstBook.setIsbn(FIRST_ISBN);
		firstBook.setIsBorrowed(true);
		bookRepository.save(firstBook);

		FIRST_BOOK_ID = firstBook.getId();

		Book secondBook = new Book();
		secondBook.setAuthor(SECOND_AUTHOR);
		secondBook.setTitle(SECOND_TITLE);
		secondBook.setPublicationYear(PUBLICATION_YEAR);
		secondBook.setIsbn(SECOND_ISBN);
		secondBook.setIsBorrowed(false);
		bookRepository.save(secondBook);

		SECOND_BOOK_ID = secondBook.getId();

	}

	@Override
	protected BooksListInquiryResource createRequest() throws Exception {
		return new BooksListInquiryResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.GET;
	}

	@Override
	protected String apiURL() throws Exception {
		return URL;
	}

	@Override
	protected void assertResults(BooksListInquiryAPIResponse response) throws Exception {
		assertSuccess();
		assertEquals(response.getBooks().size(), 2);
		for (com.example.mypkg.outbound.domain.resources.Book book : response.getBooks()) {
			if (FIRST_BOOK_ID.equals(book.getId())) {
				assertEquals(book.getAuthor(), FIRST_AUTHOR);
				assertEquals(book.getTitle(), FIRST_TITLE);
				assertEquals(book.getIsbn(), FIRST_ISBN);
				assertTrue(book.getIsBorrowed());
			} else {
				assertEquals(book.getId(), SECOND_BOOK_ID);
				assertEquals(book.getAuthor(), SECOND_AUTHOR);
				assertEquals(book.getTitle(), SECOND_TITLE);
				assertEquals(book.getIsbn(), SECOND_ISBN);
				assertFalse(book.getIsBorrowed());
			}
			assertEquals(book.getPublicationYear(), PUBLICATION_YEAR);
		}
	}

}
