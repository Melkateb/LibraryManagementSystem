/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.update;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.PatronsManageController;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.outbound.api.response.PatronUpdateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest
		extends GenericAPITest<com.example.mypkg.inbound.domain.resources.Patron, PatronUpdateAPIResponse> {

	@Value("${patronDelete.url}")
	private String URL;

	private String PATRON_ID;
	private String NAME = "NAME";
	private String MOBILE = "+971125896745";
	private String NEW_MOBILE = "00971585045336";
	private String ADDRESS = "222 Oak Lane, Springfield, State, Zip Code";
	private String NEW_ADDRESS = "333 Oak Lane, Springfield, State, Zip Code";
	private String EMAIL = "test@gmail.com";
	private Date BIRTHDATE = new Date();

	@InjectMocks
	private PatronsManageController patronsManageController;

	@Autowired
	PatronRepository patronRepository;

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
	protected com.example.mypkg.inbound.domain.resources.Patron createRequest() throws Exception {
		com.example.mypkg.inbound.domain.resources.Patron patron = new com.example.mypkg.inbound.domain.resources.Patron();
		patron.setMobile(NEW_MOBILE);
		patron.setAddress(NEW_ADDRESS);
		return patron;
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.PUT;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, PATRON_ID);
	}

	@Override
	protected void assertResults(PatronUpdateAPIResponse response) throws Exception {
		assertSuccess();
		Patron patron = patronRepository.findById(PATRON_ID).get();
		assertEquals(patron.getName(), NAME);
		assertEquals(patron.getMobile(), NEW_MOBILE);
		assertEquals(patron.getAddress(), NEW_ADDRESS);
		assertEquals(patron.getEmail(), EMAIL);
		assertEquals(patron.getBirthdate(), BIRTHDATE);
	}

}
