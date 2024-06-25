/**
 * 
 */
package com.example.mypkg.library.management.system.test.book.create;

import java.util.Date;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BooksManageController;
import com.example.mypkg.domain.exceptions.BookAlreadyExistsException;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.inbound.resources.BookCreateResource;
import com.example.mypkg.outbound.api.response.BookCreateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BooksManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class BookAlreadyExistsTest extends GenericAPITest<BookCreateResource, BookCreateAPIResponse> {

	@Value("${bookCreate.url}")
	private String URL;

	private String AUTHOR = "Author 1";
	private String TITLE = "Title 1";
	private Date PUBLICATION_YEAR = new Date();
	private String ISBN = "0-596-52068-9";

	@InjectMocks
	private BooksManageController booksManageController;

	@Autowired
	BookRepository bookRepository;

	@Override
	protected void initializeDataBase() throws Exception {

		Book book = new Book();
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);
		bookRepository.save(book);

	}

	@Override
	protected BookCreateResource createRequest() throws Exception {
		BookCreateResource bookCreateResource = new BookCreateResource();
		bookCreateResource.setAuthor(AUTHOR);
		bookCreateResource.setTitle(TITLE);
		bookCreateResource.setPublicationYear(PUBLICATION_YEAR);
		bookCreateResource.setIsbn(ISBN);
		return bookCreateResource;
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.POST;
	}

	@Override
	protected String apiURL() throws Exception {
		return URL;
	}

	@Override
	protected void assertResults(BookCreateAPIResponse response) throws Exception {
		assertFailure(BookAlreadyExistsException.class);
	}

}
