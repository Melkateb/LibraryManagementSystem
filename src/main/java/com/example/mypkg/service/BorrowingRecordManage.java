/**
 * 
 */
package com.example.mypkg.service;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.outbound.domain.resources.BorrowingRecordCreateResponse;
import com.example.mypkg.outbound.response.BorrowingRecordUpdateResponse;

/**
 * @author MRKAT
 *
 */
@Service
public interface BorrowingRecordManage {

	public BorrowingRecordCreateResponse addBorrowingRecord(BorrowingRecordCreateCommand borrowingRecordCreateCommand)
			throws AppException;

	public BorrowingRecordUpdateResponse updateBorrowingRecord(
			BorrowingRecordUpdateCommand borrowingRecordUpdateCommand) throws AppException;
}
