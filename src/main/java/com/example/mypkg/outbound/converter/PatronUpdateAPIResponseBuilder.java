/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.PatronUpdateAPIResponse;
import com.example.mypkg.outbound.response.PatronUpdateResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronUpdateAPIResponseBuilder extends APIResponseBuilder<PatronUpdateResponse, PatronUpdateAPIResponse> {

	@Override
	protected PatronUpdateAPIResponse transformMessage(PatronUpdateResponse serviceResponse) {
		return new PatronUpdateAPIResponse();
	}

}
