/**
 * 
 */
package com.example.mypkg.outbound.response;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronsListInquiryResponse {

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
	public PatronsListInquiryResponse(List<Patron> patrons) {
		super();
		this.patrons = patrons;
	}

	/**
	 * 
	 */
	public PatronsListInquiryResponse() {
		super();
	}

}
