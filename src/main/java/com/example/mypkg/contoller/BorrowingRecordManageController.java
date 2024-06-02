/**
 * 
 */
package com.example.mypkg.contoller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.builders.ResponseMessage;
import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.inbound.converter.BorrowingRecordCreateCommandBuilder;
import com.example.mypkg.inbound.converter.BorrowingRecordUpdateCommandBuilder;
import com.example.mypkg.inbound.resources.BorrowingRecordCreateResource;
import com.example.mypkg.inbound.resources.BorrowingRecordUpdateResource;
import com.example.mypkg.outbound.api.response.BorrowingRecordCreateAPIResponse;
import com.example.mypkg.outbound.api.response.BorrowingRecordUpdateAPIResponse;
import com.example.mypkg.outbound.converter.BorrowingRecordCreateAPIResponseBuilder;
import com.example.mypkg.outbound.converter.BorrowingRecordUpdateAPIResponseBuilder;
import com.example.mypkg.outbound.domain.resources.BorrowingRecordCreateResponse;
import com.example.mypkg.outbound.response.BorrowingRecordUpdateResponse;
import com.example.mypkg.service.BorrowingRecordManage;

/**
 * @author MRKAT
 *
 */
@RestController
@RequestMapping("/api")
public class BorrowingRecordManageController {

	@Autowired
	BorrowingRecordManage borrowingRecordManage;

	@Autowired
	BorrowingRecordCreateCommandBuilder borrowingRecordCreateCommandBuilder;

	@Autowired
	BorrowingRecordCreateAPIResponseBuilder borrowingRecordCreateAPIResponseBuilder;

	@Autowired
	BorrowingRecordUpdateCommandBuilder borrowingRecordUpdateCommandBuilder;

	@Autowired
	BorrowingRecordUpdateAPIResponseBuilder borrowingRecordUpdateAPIResponseBuilder;

	@PostMapping("/borrow/{bookId}/patron/{patronId}")
	private ResponseMessage<BorrowingRecordCreateAPIResponse> createBorrowingRecord(
			@NotBlank @PathVariable("bookId") String bookId, @NotBlank @PathVariable("patronId") String patronId)
			throws ApplicationException {
		BorrowingRecordCreateResource borrowingRecordCreateResource = new BorrowingRecordCreateResource(bookId,
				patronId);
		BorrowingRecordCreateCommand borrowingRecordCreateCommand = borrowingRecordCreateCommandBuilder
				.buildServiceInput(borrowingRecordCreateResource);
		BorrowingRecordCreateResponse borrowingRecordCreateResponse = borrowingRecordManage
				.addBorrowingRecord(borrowingRecordCreateCommand);
		return borrowingRecordCreateAPIResponseBuilder.buildServiceOutput(borrowingRecordCreateResponse);
	}

	@PutMapping("/return/{bookId}/patron/{patronId}")
	private ResponseMessage<BorrowingRecordUpdateAPIResponse> updateBorrowingRecord(
			@NotBlank @PathVariable("bookId") String bookId, @NotBlank @PathVariable("patronId") String patronId)
			throws ApplicationException {
		BorrowingRecordUpdateResource borrowingRecordUpdateResource = new BorrowingRecordUpdateResource(bookId,
				patronId);
		BorrowingRecordUpdateCommand borrowingRecordUpdateCommand = borrowingRecordUpdateCommandBuilder
				.buildServiceInput(borrowingRecordUpdateResource);
		BorrowingRecordUpdateResponse borrowingRecordUpdateResponse = borrowingRecordManage
				.updateBorrowingRecord(borrowingRecordUpdateCommand);
		return borrowingRecordUpdateAPIResponseBuilder.buildServiceOutput(borrowingRecordUpdateResponse);
	}
}
