/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.PatronInquiryCommand;
import com.example.mypkg.inbound.resources.PatronInquiryResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronInquiryCommandBuilder extends ServiceInputBuilder<PatronInquiryResource, PatronInquiryCommand> {

	@Override
	protected PatronInquiryCommand transformMessage(PatronInquiryResource requestInput) throws ApplicationException {
		return new PatronInquiryCommand(requestInput.getId());
	}

}
