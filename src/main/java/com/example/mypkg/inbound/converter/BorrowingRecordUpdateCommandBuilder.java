/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.inbound.resources.BorrowingRecordUpdateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BorrowingRecordUpdateCommandBuilder
		extends ServiceInputBuilder<BorrowingRecordUpdateResource, BorrowingRecordUpdateCommand> {

	@Override
	protected BorrowingRecordUpdateCommand transformMessage(BorrowingRecordUpdateResource requestInput)
			throws ApplicationException {
		return new BorrowingRecordUpdateCommand(requestInput.getBookId(), requestInput.getPatronId());
	}

}
