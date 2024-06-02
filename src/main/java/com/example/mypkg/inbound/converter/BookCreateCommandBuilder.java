/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BookCreateCommand;
import com.example.mypkg.inbound.resources.BookCreateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BookCreateCommandBuilder extends ServiceInputBuilder<BookCreateResource, BookCreateCommand> {

	@Override
	protected BookCreateCommand transformMessage(BookCreateResource requestInput) throws ApplicationException {
		return new BookCreateCommand(requestInput.getTitle(), requestInput.getAuthor(),
				requestInput.getPublicationYear(), requestInput.getIsbn());
	}

}
