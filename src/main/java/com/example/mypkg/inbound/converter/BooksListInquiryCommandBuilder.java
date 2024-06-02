/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BooksListInquiryCommand;
import com.example.mypkg.inbound.resources.BooksListInquiryResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BooksListInquiryCommandBuilder
		extends ServiceInputBuilder<BooksListInquiryResource, BooksListInquiryCommand> {

	@Override
	protected BooksListInquiryCommand transformMessage(BooksListInquiryResource requestInput) throws ApplicationException {
		return new BooksListInquiryCommand();
	}

}
