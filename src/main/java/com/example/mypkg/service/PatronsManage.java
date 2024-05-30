/**
 * 
 */
package com.example.mypkg.service;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.PatronCreateCommand;
import com.example.mypkg.inbound.command.PatronInquiryCommand;
import com.example.mypkg.inbound.command.PatronRemoveCommand;
import com.example.mypkg.inbound.command.PatronUpdateCommand;
import com.example.mypkg.inbound.command.PatronsListInquiryCommand;
import com.example.mypkg.outbound.response.PatronCreateResponse;
import com.example.mypkg.outbound.response.PatronInquiryResponse;
import com.example.mypkg.outbound.response.PatronRemoveResponse;
import com.example.mypkg.outbound.response.PatronUpdateResponse;
import com.example.mypkg.outbound.response.PatronsListInquiryResponse;

/**
 * @author MRKAT
 *
 */
@Service
public interface PatronsManage {

	public PatronsListInquiryResponse getAllPatrons(PatronsListInquiryCommand patronsListInquiryCommand)
			throws AppException;

	public PatronInquiryResponse getPatronById(PatronInquiryCommand patronInquiryCommand) throws AppException;

	public PatronCreateResponse addPatron(PatronCreateCommand patronCreateCommand) throws AppException;

	public PatronUpdateResponse updatePatron(PatronUpdateCommand patronUpdateCommand) throws AppException;

	public PatronRemoveResponse deletePatron(PatronRemoveCommand patronRemoveCommand) throws AppException;
}
