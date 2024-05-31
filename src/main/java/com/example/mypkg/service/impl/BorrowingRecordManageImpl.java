/**
 * 
 */
package com.example.mypkg.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.domain.model.BorrowingRecord;
import com.example.mypkg.domain.repository.BorrowingRecordRepository;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.outbound.domain.resources.BorrowingRecordCreateResponse;
import com.example.mypkg.outbound.response.BorrowingRecordUpdateResponse;
import com.example.mypkg.service.BorrowingRecordManage;

/**
 * @author MRKAT
 *
 */
@Service
public class BorrowingRecordManageImpl implements BorrowingRecordManage {

	@Autowired
	BorrowingRecordRepository borrowingRecordRepository;

	@Override
	public BorrowingRecordCreateResponse addBorrowingRecord(BorrowingRecordCreateCommand borrowingRecordCreateCommand)
			throws AppException {
		// TODO check that book record not found
		BorrowingRecord borrowingRecord = new BorrowingRecord();
		borrowingRecord.setBookId(borrowingRecordCreateCommand.getBookId());
		borrowingRecord.setPatronId(borrowingRecordCreateCommand.getPatronId());
		borrowingRecord.setBorrowDate(new Date());
		borrowingRecordRepository.save(borrowingRecord);
		return new BorrowingRecordCreateResponse();
	}

	@Override
	public BorrowingRecordUpdateResponse updateBorrowingRecord(
			BorrowingRecordUpdateCommand borrowingRecordUpdateCommand) throws AppException {
		// TODO handle that book record doesn't exists
		BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(
				borrowingRecordUpdateCommand.getBookId(), borrowingRecordUpdateCommand.getPatronId()).get();
		borrowingRecord.setReturnDate(new Date());
		borrowingRecordRepository.save(borrowingRecord);
		return new BorrowingRecordUpdateResponse(borrowingRecord.getBorrowDate(), borrowingRecord.getReturnDate());
	}

}
