/**
 * 
 */
package com.example.mypkg.builders;

import org.springframework.stereotype.Service;

/**
 * @author MRKAT
 *
 */
@Service
public abstract class APIResponseBuilder<T, E> {

	ResponseBuilder responseBuilder;

	public ResponseMessage<E> buildServiceOutput(T serviceResponse) {

		ResponseMessage<E> resp = responseBuilder.buildResponse(serviceResponse);
		if (serviceResponse != null && !(serviceResponse.getClass().equals(java.lang.Boolean.class))) {

			resp.setData(transformMessage(serviceResponse));
		}
		return resp;

	}

	protected abstract E transformMessage(T serviceResponse);

	public ResponseBuilder getResponseBuilder() {
		return responseBuilder;
	}

	public void setResponseBuilder(ResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

}
