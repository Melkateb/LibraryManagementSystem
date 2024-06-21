/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.update;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
import com.example.mypkg.outbound.api.response.BookUpdateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest
		extends GenericAPITest<com.example.mypkg.inbound.domain.resources.Book, BookUpdateAPIResponse> {

	@Value("${bookUpdate.url}")
	private String URL;

	private String BOOK_ID;
	private String AUTHOR = "Author";
	private String NEW_AUTHOR = "New author";
	private String TITLE = "Title";
	private String NEW_TITLE = "New title";
	private Date PUBLICATION_YEAR = new Date();
	private String ISBN = "1112221";
	private String NEW_ISBN = "111222";

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
		assertSuccess();
		Book book = bookRepository.findById(BOOK_ID).get();
		assertEquals(book.getTitle(), NEW_TITLE);
		assertEquals(book.getAuthor(), NEW_AUTHOR);
		assertFalse(book.getIsBorrowed());
		assertEquals(book.getPublicationYear(), PUBLICATION_YEAR);
		assertEquals(book.getIsbn(), NEW_ISBN);
	}

}
