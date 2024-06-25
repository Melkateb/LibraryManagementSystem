/**
 * 
 */
package com.example.mypkg.library.management.system.test.patron.list.inquiry;

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
import com.example.mypkg.inbound.resources.PatronsListInquiryResource;
import com.example.mypkg.outbound.api.response.PatronsListInquiryAPIResponse;
import com.example.mypkg.test.GenericAPITest;

/**
 * @author MRKAT
 *
 */
@WebMvcTest(controllers = PatronsManageController.class)
@TestPropertySource(locations = { "/apiurl.properties" })
public class HappyScenarioTest extends GenericAPITest<PatronsListInquiryResource, PatronsListInquiryAPIResponse> {

	@Value("${patronListInquiry.url}")
	private String URL;

	private String FIRST_PATRON_ID;
	private String SECOND_PATRON_ID;
	private String FIRST_NAME = "NAME 1";
	private String SECOND_NAME = "NAME 2";
	private String FIRST_MOBILE = "+97141234567";
	private String SECOND_MOBILE = "00971585045336";
	private String FIRST_ADDRESS = "222 Oak Lane, Springfield, State, Zip Code";
	private String SECOND_ADDRESS = "999 Elm Street, Cityville, State, Zip Code";
	private String FIRST_EMAIL = "test1@gmail.com";
	private String SECOND_EMAIL = "test2@gmail.com";
	private Date BIRTHDATE = new Date();

	@InjectMocks
	private PatronsManageController patronsManageController;

	@Autowired
	PatronRepository patronRepository;

	@Override
	protected void initializeDataBase() throws Exception {

		Patron firstPatron = new Patron();
		firstPatron.setName(FIRST_NAME);
		firstPatron.setMobile(FIRST_MOBILE);
		firstPatron.setAddress(FIRST_ADDRESS);
		firstPatron.setEmail(FIRST_EMAIL);
		firstPatron.setBirthdate(BIRTHDATE);
		patronRepository.save(firstPatron);

		FIRST_PATRON_ID = firstPatron.getId();

		Patron secondPatron = new Patron();
		secondPatron.setName(SECOND_NAME);
		secondPatron.setMobile(SECOND_MOBILE);
		secondPatron.setAddress(SECOND_ADDRESS);
		secondPatron.setEmail(SECOND_EMAIL);
		secondPatron.setBirthdate(BIRTHDATE);
		patronRepository.save(secondPatron);

		SECOND_PATRON_ID = secondPatron.getId();
	}

	@Override
	protected PatronsListInquiryResource createRequest() throws Exception {
		return new PatronsListInquiryResource();
	}

	@Override
	protected HttpMethod getHttpMethod() throws Exception {
		return HttpMethod.GET;
	}

	@Override
	protected String apiURL() throws Exception {
		return URL;
	}

	@Override
	protected void assertResults(PatronsListInquiryAPIResponse response) throws Exception {
		assertSuccess();
		assertEquals(response.getPatrons().size(), 2);
		for (com.example.mypkg.outbound.domain.resources.Patron patron : response.getPatrons()) {
			if (FIRST_PATRON_ID.equals(patron.getId())) {
				assertEquals(patron.getName(), FIRST_NAME);
				assertEquals(patron.getMobile(), FIRST_MOBILE);
				assertEquals(patron.getAddress(), FIRST_ADDRESS);
				assertEquals(patron.getEmail(), FIRST_EMAIL);
			} else {
				assertEquals(patron.getId(), SECOND_PATRON_ID);
				assertEquals(patron.getName(), SECOND_NAME);
				assertEquals(patron.getMobile(), SECOND_MOBILE);
				assertEquals(patron.getAddress(), SECOND_ADDRESS);
				assertEquals(patron.getEmail(), SECOND_EMAIL);
			}
			assertEquals(patron.getBirthdate(), BIRTHDATE);
		}
	}

}
