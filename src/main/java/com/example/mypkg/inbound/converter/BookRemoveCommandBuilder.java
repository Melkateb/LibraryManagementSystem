/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BookRemoveCommand;
import com.example.mypkg.inbound.resources.BookRemoveResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BookRemoveCommandBuilder extends ServiceInputBuilder<BookRemoveResource, BookRemoveCommand> {

	@Override
	protected BookRemoveCommand transformMessage(BookRemoveResource requestInput) throws ApplicationException {
		return new BookRemoveCommand(requestInput.getId());
	}

}
