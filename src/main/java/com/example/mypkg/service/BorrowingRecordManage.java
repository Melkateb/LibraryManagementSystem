/**
 * 
 */
package com.example.mypkg.service;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.outbound.response.BorrowingRecordCreateResponse;
import com.example.mypkg.outbound.response.BorrowingRecordUpdateResponse;

/**
 * @author MRKAT
 *
 */
@Service
public interface BorrowingRecordManage {

	public BorrowingRecordCreateResponse addBorrowingRecord(BorrowingRecordCreateCommand borrowingRecordCreateCommand)
			throws ApplicationException;

	public BorrowingRecordUpdateResponse updateBorrowingRecord(
			BorrowingRecordUpdateCommand borrowingRecordUpdateCommand) throws ApplicationException;
}
