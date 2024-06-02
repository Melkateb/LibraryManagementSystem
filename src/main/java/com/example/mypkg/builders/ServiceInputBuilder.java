/**
 * 
 */
package com.example.mypkg.builders;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.ApplicationException;

/**
 * @author MRKAT
 *
 */
@Service
public abstract class ServiceInputBuilder<T, E> {

	protected abstract E transformMessage(T requestInput) throws ApplicationException;

	public E buildServiceInput(T requestInput) throws ApplicationException {
		E serviceInput = transformMessage(requestInput);
		return serviceInput;
	}
}
