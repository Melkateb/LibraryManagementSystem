/**
 * 
 */
package com.example.mypkg.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.lang.reflect.ParameterizedType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mypkg.builders.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author MRKAT
 *
 */
@EnableAspectJAutoProxy
@AutoConfigureDataJpa
@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericAPITest<T, U> {

	@Autowired
	private MockMvc mockMvc;

	private MvcResult mvcResult;

	@BeforeEach
	protected void beforeTestRun() throws Exception {
		initializeDataBase();
	}

	protected abstract void initializeDataBase() throws Exception;

	@Test
	public void test() throws Exception {
		T resource = createRequest();
		mvcResult = sendRequest(resource);
		ResponseMessage<U> apiResponse = getAPIResponse();
		assertResults(apiResponse.getData());

	}

	private MvcResult sendRequest(T resource) throws Exception {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonResource = objectWriter.writeValueAsString(resource);
		HttpMethod httpMethod = this.getHttpMethod();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.request(httpMethod, this.apiURL()).content(jsonResource)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andDo(print()).andReturn();
		return mvcResult;
	}

	protected abstract T createRequest() throws Exception;

	private ResponseMessage<U> getAPIResponse() throws Exception {
		String responseString = this.mvcResult.getResponse().getContentAsString();
		ResponseMessage apiResponseMessage = getResponseMessage(responseString);
		apiResponseMessage.setData(getAPIResponse(apiResponseMessage,
				(Class<U>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]));
		return apiResponseMessage;
	}

	protected abstract HttpMethod getHttpMethod() throws Exception;

	protected abstract String apiURL() throws Exception;

	private ResponseMessage<?> getResponseMessage(String response) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(response, ResponseMessage.class);
	}

	private Object getAPIResponse(ResponseMessage<?> response, Class tragetClass) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(response.getData(), tragetClass);
	}

	protected void assertFailure(Class<? extends Exception> exception) throws Exception {
		assertThat(this.mvcResult.getResolvedException().getClass()).isEqualTo(exception);
	}

	protected void assertSuccess() throws Exception {
		assertThat(this.mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	protected abstract void assertResults(U response) throws Exception;

}
