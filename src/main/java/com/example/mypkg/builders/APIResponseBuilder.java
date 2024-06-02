/**
 * 
 */
package com.example.mypkg.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author MRKAT
 *
 */
@Data
@Component
public abstract class APIResponseBuilder<T, E> {

	@Autowired
	ResponseBuilder responseBuilder;

	public ResponseMessage<E> buildServiceOutput(T serviceResponse) {

		ResponseMessage<E> resp = responseBuilder.buildResponse(serviceResponse);
		if (serviceResponse != null && !(serviceResponse.getClass().equals(java.lang.Boolean.class))) {
			resp.setData(transformMessage(serviceResponse));
		}
		return resp;

	}

	protected abstract E transformMessage(T serviceResponse);

}
