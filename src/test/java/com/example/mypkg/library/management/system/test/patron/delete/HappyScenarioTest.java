/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.delete;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.PatronsManageController;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.inbound.resources.PatronRemoveResource;
import com.example.mypkg.outbound.api.response.PatronRemoveAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<PatronRemoveResource, PatronRemoveAPIResponse> {

	@Value("${patronDelete.url}")
	private String URL;

	private String PATRON_ID;
	private String NAME = "NAME 1";
	private String MOBILE = "+971125896745";
	private String ADDRESS = "222 Oak Lane, Springfield, State, Zip Code";
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
	protected PatronRemoveResource createRequest() throws Exception {
		return new PatronRemoveResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.DELETE;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, PATRON_ID);
	}

	@Override
	protected void assertResults(PatronRemoveAPIResponse response) throws Exception {
		assertSuccess();
		Optional<Patron> optionalPatron = patronRepository.findById(PATRON_ID);
		assertFalse(optionalPatron.isPresent());
	}

}
