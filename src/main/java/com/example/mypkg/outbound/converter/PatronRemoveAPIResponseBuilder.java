/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.outbound.api.response.PatronRemoveAPIResponse;
import com.example.mypkg.outbound.response.PatronRemoveResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronRemoveAPIResponseBuilder extends APIResponseBuilder<PatronRemoveResponse, PatronRemoveAPIResponse> {

	@Override
	protected PatronRemoveAPIResponse transformMessage(PatronRemoveResponse serviceResponse) throws AppException {
		return new PatronRemoveAPIResponse();
	}

}
