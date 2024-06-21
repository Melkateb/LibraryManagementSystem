package com.example.mypkg.library.management.system.test.patron.inquiry;

import java.util.Date;
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
import com.example.mypkg.inbound.resources.PatronInquiryResource;
import com.example.mypkg.outbound.api.response.PatronInquiryAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class PatronNotFoundTest extends GenericAPITest<PatronInquiryResource, PatronInquiryAPIResponse> {

	@Value("${patronInquiry.url}")
	private String URL;

	private String PATRON_ID = UUID.randomUUID().toString();
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
	protected PatronInquiryResource createRequest() throws Exception {
		return new PatronInquiryResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.GET;
	}

	@Override
	protected String apiURL() throws Exception {
		return String.format(URL, PATRON_ID);
	}

	@Override
	protected void assertResults(PatronInquiryAPIResponse response) throws Exception {
		assertFailure(PatronNotFoundException.class);
	}

}
