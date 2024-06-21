/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.update;

import java.util.UUID;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;

import com.example.mypkg.contoller.PatronsManageController;
import com.example.mypkg.domain.exceptions.PatronNotFoundException;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.outbound.api.response.PatronUpdateAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class PatronNotFoundTest
		extends GenericAPITest<com.example.mypkg.inbound.domain.resources.Patron, PatronUpdateAPIResponse> {

	@Value("${patronDelete.url}")
	private String URL;

	private String PATRON_ID = UUID.randomUUID().toString();
	private String NEW_MOBILE = "+971125896743";
	private String NEW_ADDRESS = "333 Oak Lane, Springfield, State, Zip Code";

	@InjectMocks
	private PatronsManageController patronsManageController;

	@Autowired
	PatronRepository patronRepository;

	@Override
	protected void initializeDataBase() throws Exception {

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
		assertFailure(PatronNotFoundException.class);
	}

}
