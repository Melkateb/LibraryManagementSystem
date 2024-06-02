/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.PatronCreateCommand;
import com.example.mypkg.inbound.resources.PatronCreateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronCreateCommandBuilder extends ServiceInputBuilder<PatronCreateResource, PatronCreateCommand> {

	@Override
	protected PatronCreateCommand transformMessage(PatronCreateResource requestInput) throws ApplicationException {
		return new PatronCreateCommand(requestInput.getName(), requestInput.getContactInformation());
	}

}
