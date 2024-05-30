/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.PatronUpdateCommand;
import com.example.mypkg.inbound.resources.PatronUpdateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronUpdateCommandBuilder extends ServiceInputBuilder<PatronUpdateResource, PatronUpdateCommand> {

	@Override
	protected PatronUpdateCommand transformMessage(PatronUpdateResource requestInput) throws AppException {
		return new PatronUpdateCommand(requestInput.getId(), requestInput.getPatron());
	}

}
