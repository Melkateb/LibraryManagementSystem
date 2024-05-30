/**
 * 
 */
package com.example.mypkg.outbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.outbound.api.response.PatronInquiryAPIResponse;
import com.example.mypkg.outbound.domain.resources.Patron;
import com.example.mypkg.outbound.response.PatronInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronInquiryAPIResponseBuilder
		extends APIResponseBuilder<PatronInquiryResponse, PatronInquiryAPIResponse> {

	@Override
	protected PatronInquiryAPIResponse transformMessage(PatronInquiryResponse serviceResponse) throws AppException {
		return new PatronInquiryAPIResponse(new Patron(serviceResponse.getPatron()));
	}

}
