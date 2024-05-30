/**
 * 
 */
package com.example.mypkg.outbound.api.response;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.outbound.domain.resources.Patron;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronInquiryAPIResponse {

	@JsonProperty("patron")
	private Patron patron;

	/**
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	/**
	 * @param patron
	 */
	public PatronInquiryAPIResponse(Patron patron) {
		super();
		this.patron = patron;
	}

	/**
	 * 
	 */
	public PatronInquiryAPIResponse() {
		super();
	}

}
