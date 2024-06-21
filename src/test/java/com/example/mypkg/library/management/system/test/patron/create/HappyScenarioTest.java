/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.example.mypkg.inbound.resources.PatronCreateResource;
import com.example.mypkg.outbound.api.response.PatronCreateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<PatronCreateResource, PatronCreateAPIResponse> {

	@Value("${patronCreate.url}")
	private String URL;

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

	}

	@Override
	protected PatronCreateResource createRequest() throws Exception {
		PatronCreateResource patronCreateResource = new PatronCreateResource();
		patronCreateResource.setName(NAME);
		patronCreateResource.setMobile(MOBILE);
		patronCreateResource.setAddress(ADDRESS);
		patronCreateResource.setEmail(EMAIL);
		patronCreateResource.setBirthdate(BIRTHDATE);
		return patronCreateResource;
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
	protected void assertResults(PatronCreateAPIResponse response) throws Exception {
		assertSuccess();
		Optional<Patron> optionalPatron = patronRepository.findByNameAndMobile(NAME, MOBILE);
		assertTrue(optionalPatron.isPresent());
		assertEquals(optionalPatron.get().getAddress(), ADDRESS);
		assertEquals(optionalPatron.get().getEmail(), EMAIL);
		assertEquals(optionalPatron.get().getBirthdate(), BIRTHDATE);
	}

}
