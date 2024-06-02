/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.PatronUpdateCommand;
import com.example.mypkg.inbound.resources.PatronUpdateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronUpdateCommandBuilder extends ServiceInputBuilder<PatronUpdateResource, PatronUpdateCommand> {

	@Override
	protected PatronUpdateCommand transformMessage(PatronUpdateResource requestInput) throws ApplicationException {
		return new PatronUpdateCommand(requestInput.getId(), requestInput.getPatron());
	}

}
