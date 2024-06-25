package com.example.mypkg.library.management.system.test.borrowingrecord.update;

/**
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BorrowingRecordManageController;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.model.BorrowingRecord;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.domain.repository.BorrowingRecordRepository;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.inbound.resources.BorrowingRecordUpdateResource;
import com.example.mypkg.outbound.api.response.BorrowingRecordUpdateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BorrowingRecordManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<BorrowingRecordUpdateResource, BorrowingRecordUpdateAPIResponse> {

	@Value("${borrowingRecordUpdate.url}")
	private String URL;

	private String BOOK_ID;
	private String AUTHOR = "Author";
	private String TITLE = "Title";
	private Date PUBLICATION_YEAR = new Date();
	private String ISBN = "1112221";

	private String PATRON_ID;
	private String NAME = "NAME 1";
	private String MOBILE = "+97141234567";
	private String ADDRESS = "222 Oak Lane, Springfield, State, Zip Code";
	private String EMAIL = "test@gmail.com";
	private Date BIRTHDATE = new Date();

	private Date BORROWING_DATE = new Date();
	private String BORROWING_RECORD_ID;

	@InjectMocks
	private BorrowingRecordManageController borrowingRecordManageController;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PatronRepository patronRepository;

	@Autowired
	BorrowingRecordRepository borrowingRecordRepository;

	@Override
	protected void initializeDataBase() throws Exception {

		Book book = new Book();
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);
		book.setPublicationYear(PUBLICATION_YEAR);
		book.setIsbn(ISBN);
		bookRepository.save(book);

		BOOK_ID = book.getId();

		Patron patron = new Patron();
		patron.setName(NAME);
		patron.setMobile(MOBILE);
		patron.setAddress(ADDRESS);
		patron.setEmail(EMAIL);
		patron.setBirthdate(BIRTHDATE);
		patronRepository.save(patron);

		PATRON_ID = patron.getId();

		BorrowingRecord borrowingRecord = new BorrowingRecord();
		borrowingRecord.setBookId(BOOK_ID);
		borrowingRecord.setPatronId(PATRON_ID);
		borrowingRecord.setBorrowDate(BORROWING_DATE);
		borrowingRecordRepository.save(borrowingRecord);

		BORROWING_RECORD_ID = borrowingRecord.getId();
	}

	@Override
	protected BorrowingRecordUpdateResource createRequest() throws Exception {
		return new BorrowingRecordUpdateResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.PUT;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, BOOK_ID, PATRON_ID);
	}

	@Override
	protected void assertResults(BorrowingRecordUpdateAPIResponse response) throws Exception {
		assertSuccess();
		BorrowingRecord borrowingRecord = borrowingRecordRepository.findById(BORROWING_RECORD_ID).get();

		assertEquals(response.getBorrowingDate(), BORROWING_DATE);
		assertEquals(borrowingRecord.getBookId(), BOOK_ID);
		assertEquals(borrowingRecord.getPatronId(), PATRON_ID);
		assertEquals(borrowingRecord.getBorrowDate(), BORROWING_DATE);
		assertNotNull(borrowingRecord.getReturnDate());

		Book book = bookRepository.findById(BOOK_ID).get();
		assertFalse(book.getIsBorrowed());

		Patron patron = patronRepository.findById(PATRON_ID).get();
		assertFalse(patron.getBorrowedBooks().contains(BOOK_ID));
	}

}
