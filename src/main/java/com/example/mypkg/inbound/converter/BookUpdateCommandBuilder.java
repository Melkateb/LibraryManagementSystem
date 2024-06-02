/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BookUpdateCommand;
import com.example.mypkg.inbound.resources.BookUpdateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BookUpdateCommandBuilder extends ServiceInputBuilder<BookUpdateResource, BookUpdateCommand> {

	@Override
	protected BookUpdateCommand transformMessage(BookUpdateResource requestInput) throws ApplicationException {
		return new BookUpdateCommand(requestInput.getId(), requestInput.getBook());
	}

}
