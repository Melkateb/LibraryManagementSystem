/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.delete;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BooksManageController;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.inbound.resources.BookRemoveResource;
import com.example.mypkg.outbound.api.response.BookRemoveAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<BookRemoveResource, BookRemoveAPIResponse> {

	@Value("${bookDelete.url}")
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
	protected BookRemoveResource createRequest() throws Exception {
		return new BookRemoveResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.DELETE;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, BOOK_ID);
	}

	@Override
	protected void assertResults(BookRemoveAPIResponse response) throws Exception {
		assertSuccess();
		Optional<Book> optionalBook = bookRepository.findById(BOOK_ID);
		assertFalse(optionalBook.isPresent());
	}

}
