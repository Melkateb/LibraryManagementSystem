/**
 * 
 */
package com.example.mypkg.builders;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.AppException;

/**
 * @author MRKAT
 *
 */
@Service
public abstract class APIResponseBuilder<T, E> {

	protected abstract E transformMessage(T serviceResponse) throws AppException;

	public ResponseMessage<E> buildServiceOutput(T serviceResponse) throws AppException {
		ResponseMessage<E> resp = new ResponseMessage<E>();
		if (serviceResponse != null && !(serviceResponse.getClass().equals(java.lang.Boolean.class))) {
			resp.setData(transformMessage(serviceResponse));
		}
		return resp;
	}
}
