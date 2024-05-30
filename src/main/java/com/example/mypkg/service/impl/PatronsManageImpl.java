/**
 * 
 */
package com.example.mypkg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.PatronRepository;
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
import com.example.mypkg.service.PatronsManage;

/**
 * @author MRKAT
 *
 */
@Service
public class PatronsManageImpl implements PatronsManage {

	@Autowired
	PatronRepository patronRepository;

	@Override
	public PatronsListInquiryResponse getAllPatrons(PatronsListInquiryCommand patronsListInquiryCommand)
			throws AppException {
		List<Patron> patrons = new ArrayList<Patron>();
		patronRepository.findAll().forEach(patron -> patrons.add(patron));
		return new PatronsListInquiryResponse(patrons);
	}

	@Override
	public PatronInquiryResponse getPatronById(PatronInquiryCommand patronInquiryCommand) throws AppException {

		Optional<Patron> optionalPatron = patronRepository.findById(patronInquiryCommand.getId());
		if (!optionalPatron.isPresent()) {
			// TODO throw PatronNotFoundException;
		}
		return new PatronInquiryResponse(optionalPatron.get());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronCreateResponse addPatron(PatronCreateCommand patronCreateCommand) throws AppException {
		// TODO check that patron already exists
		Patron patron = new Patron();
		patron.setName(patronCreateCommand.getName());
		patron.setContactInformation(patronCreateCommand.getContactInformation());
		patronRepository.save(patron);
		return new PatronCreateResponse(patron.getId());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronUpdateResponse updatePatron(PatronUpdateCommand patronUpdateCommand) throws AppException {
		// TODO handle that patron doesn't exists
		Patron patron = patronRepository.findById(patronUpdateCommand.getId()).get();
		patron.setName(patronUpdateCommand.getPatron().getName());
		patron.setContactInformation(patronUpdateCommand.getPatron().getContactInformation());
		patronRepository.save(patron);
		return new PatronUpdateResponse();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronRemoveResponse deletePatron(PatronRemoveCommand patronRemoveCommand) throws AppException {
		// TODO handle that patron doesn't exists
		patronRepository.deleteById(patronRemoveCommand.getId());
		return new PatronRemoveResponse();
	}

}
