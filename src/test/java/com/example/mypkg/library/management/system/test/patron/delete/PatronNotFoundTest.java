/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.delete;

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
import com.example.mypkg.inbound.resources.PatronRemoveResource;
import com.example.mypkg.outbound.api.response.PatronRemoveAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class PatronNotFoundTest extends GenericAPITest<PatronRemoveResource, PatronRemoveAPIResponse> {

	@Value("${patronDelete.url}")
	private String URL;

	private String PATRON_ID = UUID.randomUUID().toString();

	@InjectMocks
	private PatronsManageController patronsManageController;

	@Autowired
	PatronRepository patronRepository;

	@Override
	protected void initializeDataBase() throws Exception {

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
		assertFailure(PatronNotFoundException.class);
	}

}
