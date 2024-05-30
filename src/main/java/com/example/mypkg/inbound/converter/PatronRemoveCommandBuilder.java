/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.PatronRemoveCommand;
import com.example.mypkg.inbound.resources.PatronRemoveResource;

/**
 * @author MRKAT
 *
 */
@Component
public class PatronRemoveCommandBuilder extends ServiceInputBuilder<PatronRemoveResource, PatronRemoveCommand> {

	@Override
	protected PatronRemoveCommand transformMessage(PatronRemoveResource requestInput) throws AppException {
		return new PatronRemoveCommand(requestInput.getId());
	}

}
