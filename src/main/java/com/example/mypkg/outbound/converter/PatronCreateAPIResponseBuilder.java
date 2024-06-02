/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.PatronCreateAPIResponse;
import com.example.mypkg.outbound.response.PatronCreateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronCreateAPIResponseBuilder extends APIResponseBuilder<PatronCreateResponse, PatronCreateAPIResponse> {

	@Override
	protected PatronCreateAPIResponse transformMessage(PatronCreateResponse serviceResponse) {
		return new PatronCreateAPIResponse(serviceResponse.getId());
	}

}
