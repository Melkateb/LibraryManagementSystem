/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.PatronsListInquiryCommand;
import com.example.mypkg.inbound.resources.PatronsListInquiryResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronsListInquiryCommandBuilder
		extends ServiceInputBuilder<PatronsListInquiryResource, PatronsListInquiryCommand> {

	@Override
	protected PatronsListInquiryCommand transformMessage(PatronsListInquiryResource requestInput) throws ApplicationException {
		return new PatronsListInquiryCommand();
	}

}
