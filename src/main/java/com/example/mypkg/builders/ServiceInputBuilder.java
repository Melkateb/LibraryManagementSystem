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
public abstract class ServiceInputBuilder<T, E> {

	protected abstract E transformMessage(T requestInput) throws AppException;

	public E buildServiceInput(T requestInput) throws AppException {
		E serviceInput = transformMessage(requestInput);
		return serviceInput;
	}
}
