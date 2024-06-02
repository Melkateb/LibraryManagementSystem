/**
 * 
 */
package com.example.mypkg.inbound.converter;

import org.springframework.stereotype.Component;

import com.example.mypkg.builders.ServiceInputBuilder;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.resources.BorrowingRecordCreateResource;

/**
 * @author MRKAT
 *
 */
@Component
public class BorrowingRecordCreateCommandBuilder
		extends ServiceInputBuilder<BorrowingRecordCreateResource, BorrowingRecordCreateCommand> {

	@Override
	protected BorrowingRecordCreateCommand transformMessage(BorrowingRecordCreateResource requestInput)
			throws ApplicationException {
		return new BorrowingRecordCreateCommand(requestInput.getBookId(), requestInput.getPatronId());
	}

}
