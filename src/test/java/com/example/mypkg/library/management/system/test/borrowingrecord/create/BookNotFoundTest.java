/**
 * 
 */
package com.example.mypkg.library.management.system.test.borrowingrecord.create;

import java.util.Date;
import java.util.UUID;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.BorrowingRecordManageController;
import com.example.mypkg.domain.exceptions.BookNotFoundException;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.domain.repository.BorrowingRecordRepository;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.inbound.resources.BorrowingRecordCreateResource;
import com.example.mypkg.outbound.api.response.BorrowingRecordCreateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = BorrowingRecordManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class BookNotFoundTest extends GenericAPITest<BorrowingRecordCreateResource, BorrowingRecordCreateAPIResponse> {

	@Value("${borrowingRecordCreate.url}")
	private String URL;

	private String BOOK_ID = UUID.randomUUID().toString();

	private String PATRON_ID;
	private String NAME = "NAME 1";
	private String MOBILE = "+97141234567";
	private String ADDRESS = "222 Oak Lane, Springfield, State, Zip Code";
	private String EMAIL = "test@gmail.com";
	private Date BIRTHDATE = new Date();

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

		Patron patron = new Patron();
		patron.setName(NAME);
		patron.setMobile(MOBILE);
		patron.setAddress(ADDRESS);
		patron.setEmail(EMAIL);
		patron.setBirthdate(BIRTHDATE);
		patronRepository.save(patron);

		PATRON_ID = patron.getId();

	}

	@Override
	protected BorrowingRecordCreateResource createRequest() throws Exception {
		return new BorrowingRecordCreateResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.POST;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, BOOK_ID, PATRON_ID);
	}

	@Override
	protected void assertResults(BorrowingRecordCreateAPIResponse response) throws Exception {
		assertFailure(BookNotFoundException.class);
	}

}
