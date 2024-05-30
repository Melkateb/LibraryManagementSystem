/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.BookInquiryCommand;
import com.example.mypkg.inbound.resources.BookInquiryResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BookInquiryCommandBuilder extends ServiceInputBuilder<BookInquiryResource, BookInquiryCommand> {

	@Override
	protected BookInquiryCommand transformMessage(BookInquiryResource requestInput) throws AppException {
		return new BookInquiryCommand(requestInput.getId());
	}

}
