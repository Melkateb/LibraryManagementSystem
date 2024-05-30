/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.outbound.domain.resources.Patron;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronsListInquiryAPIResponse {

	@JsonProperty("patrons")
	private List<Patron> patrons;

	/**
	 * @return the patrons
	 */
	public List<Patron> getPatrons() {
		return patrons;
	}

	/**
	 * @param patrons the patrons to set
	 */
	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}

	/**
	 * @param patrons
	 */
	public PatronsListInquiryAPIResponse(List<Patron> patrons) {
		super();
		this.patrons = patrons;
	}

	/**
	 * 
	 */
	public PatronsListInquiryAPIResponse() {
		super();
	}

}
