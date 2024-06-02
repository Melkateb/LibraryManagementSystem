/**
 * 
 */
package com.example.mypkg.outbound.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.APIResponseBuilder;
import com.example.mypkg.outbound.api.response.PatronsListInquiryAPIResponse;
import com.example.mypkg.outbound.domain.resources.Patron;
import com.example.mypkg.outbound.response.PatronsListInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronsListInquiryAPIResponseBuilder
		extends APIResponseBuilder<PatronsListInquiryResponse, PatronsListInquiryAPIResponse> {

	@Override
	protected PatronsListInquiryAPIResponse transformMessage(PatronsListInquiryResponse serviceResponse) {
		List<Patron> patrons = new ArrayList<Patron>();
		for (com.example.mypkg.domain.model.Patron patron : serviceResponse.getPatrons()) {
			Patron newPatron = new Patron(patron);
			patrons.add(newPatron);
		}
		return new PatronsListInquiryAPIResponse(patrons);
	}

}
