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

import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.domain.exceptions.PatronAlreadyExistsException;
import com.example.mypkg.domain.exceptions.PatronNotFoundException;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.BookRepository;
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

	@Autowired
	BookRepository bookRepository;

	@Override
	public PatronsListInquiryResponse getAllPatrons(PatronsListInquiryCommand patronsListInquiryCommand)
			throws ApplicationException {
		List<Patron> patrons = new ArrayList<Patron>();
		patronRepository.findAll().forEach(patron -> patrons.add(patron));
		return new PatronsListInquiryResponse(patrons);
	}

	@Override
	public PatronInquiryResponse getPatronById(PatronInquiryCommand patronInquiryCommand) throws ApplicationException {

		// Get patron
		Patron patron = getPatron(patronInquiryCommand.getId());

		// Get borrowed books
		List<Book> borrowedBooks = bookRepository.getBorrowedBooks(patron.getBorrowedBook());

		return new PatronInquiryResponse(patron, borrowedBooks);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronCreateResponse addPatron(PatronCreateCommand patronCreateCommand) throws ApplicationException {
		// Check that patron already exists
		validatePatronExistance(patronCreateCommand.getName(), patronCreateCommand.getMobile());

		// Create new patron
		Patron patron = createPatron(patronCreateCommand);
		patronRepository.save(patron);
		return new PatronCreateResponse(patron.getId());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronUpdateResponse updatePatron(PatronUpdateCommand patronUpdateCommand) throws ApplicationException {
		// Check that there is no another patron with same name and mobile
		validatePatronExistance(patronUpdateCommand.getPatron().getName(), patronUpdateCommand.getPatron().getMobile());

		// Check that patron exists
		Patron patron = getPatron(patronUpdateCommand.getId());

		// Update patron
		patron.setName(patronUpdateCommand.getPatron().getName());
		patron.setMobile(patronUpdateCommand.getPatron().getMobile());
		patron.setAddress(patronUpdateCommand.getPatron().getAddress());
		patron.setEmail(patronUpdateCommand.getPatron().getEmail());
		patron.setBirthdate(patronUpdateCommand.getPatron().getBirthdate());
		patronRepository.save(patron);
		return new PatronUpdateResponse();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatronRemoveResponse deletePatron(PatronRemoveCommand patronRemoveCommand) throws ApplicationException {
		// Check that patron exists
		getPatron(patronRemoveCommand.getId());

		// Delete patron
		patronRepository.deleteById(patronRemoveCommand.getId());
		return new PatronRemoveResponse();
	}

	private Patron getPatron(String patronId) throws PatronNotFoundException {
		Optional<Patron> optionalPatron = patronRepository.findById(patronId);
		if (!optionalPatron.isPresent()) {
			throw new PatronNotFoundException();
		}
		return optionalPatron.get();
	}

	private void validatePatronExistance(String name, String mobile) throws PatronAlreadyExistsException {
		Optional<Patron> optionalPatron = patronRepository.findByNameAndMobile(name, mobile);
		if (optionalPatron.isPresent()) {
			throw new PatronAlreadyExistsException();
		}
	}

	private Patron createPatron(PatronCreateCommand patronCreateCommand) {
		Patron patron = new Patron();
		patron.setName(patronCreateCommand.getName());
		patron.setMobile(patronCreateCommand.getMobile());
		patron.setAddress(patronCreateCommand.getAddress());
		patron.setEmail(patronCreateCommand.getEmail());
		patron.setBirthdate(patronCreateCommand.getBirthdate());
		return patron;
	}

}
