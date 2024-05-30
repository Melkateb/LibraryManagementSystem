/**
 * 
 */
package com.example.mypkg.outbound.response;

import org.springframework.validation.annotation.Validated;

import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Validated
public class PatronInquiryResponse {

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
	public PatronInquiryResponse(Patron patron) {
		super();
		this.patron = patron;
	}

	/**
	 * 
	 */
	public PatronInquiryResponse() {
		super();
	}

}
