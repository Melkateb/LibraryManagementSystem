/**
 * 
 */
package com.example.mypkg.contoller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.builders.ResponseMessage;
import com.example.mypkg.domain.exceptions.AppException;
import com.example.mypkg.inbound.command.PatronCreateCommand;
import com.example.mypkg.inbound.command.PatronInquiryCommand;
import com.example.mypkg.inbound.command.PatronRemoveCommand;
import com.example.mypkg.inbound.command.PatronUpdateCommand;
import com.example.mypkg.inbound.command.PatronsListInquiryCommand;
import com.example.mypkg.inbound.converter.PatronCreateCommandBuilder;
import com.example.mypkg.inbound.converter.PatronInquiryCommandBuilder;
import com.example.mypkg.inbound.converter.PatronRemoveCommandBuilder;
import com.example.mypkg.inbound.converter.PatronUpdateCommandBuilder;
import com.example.mypkg.inbound.converter.PatronsListInquiryCommandBuilder;
import com.example.mypkg.inbound.resources.PatronCreateResource;
import com.example.mypkg.inbound.resources.PatronInquiryResource;
import com.example.mypkg.inbound.resources.PatronRemoveResource;
import com.example.mypkg.inbound.resources.PatronUpdateResource;
import com.example.mypkg.inbound.resources.PatronsListInquiryResource;
import com.example.mypkg.outbound.api.response.PatronCreateAPIResponse;
import com.example.mypkg.outbound.api.response.PatronInquiryAPIResponse;
import com.example.mypkg.outbound.api.response.PatronRemoveAPIResponse;
import com.example.mypkg.outbound.api.response.PatronUpdateAPIResponse;
import com.example.mypkg.outbound.api.response.PatronsListInquiryAPIResponse;
import com.example.mypkg.outbound.converter.PatronCreateAPIResponseBuilder;
import com.example.mypkg.outbound.converter.PatronInquiryAPIResponseBuilder;
import com.example.mypkg.outbound.converter.PatronRemoveAPIResponseBuilder;
import com.example.mypkg.outbound.converter.PatronUpdateAPIResponseBuilder;
import com.example.mypkg.outbound.converter.PatronsListInquiryAPIResponseBuilder;
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
@RestController
@RequestMapping("/patrons")
public class PatronsManageController {

	@Autowired
	PatronsManage patronsManage;

	@Autowired
	PatronsListInquiryCommandBuilder patronsListInquiryCommandBuilder;

	@Autowired
	PatronsListInquiryAPIResponseBuilder patronsListInquiryAPIResponseBuilder;

	@Autowired
	PatronInquiryCommandBuilder patronInquiryCommandBuilder;

	@Autowired
	PatronInquiryAPIResponseBuilder patronInquiryAPIResponseBuilder;

	@Autowired
	PatronCreateCommandBuilder patronCreateCommandBuilder;

	@Autowired
	PatronCreateAPIResponseBuilder patronCreateAPIResponseBuilder;

	@Autowired
	PatronUpdateCommandBuilder patronUpdateCommandBuilder;

	@Autowired
	PatronUpdateAPIResponseBuilder patronUpdateAPIResponseBuilder;

	@Autowired
	PatronRemoveCommandBuilder patronRemoveCommandBuilder;

	@Autowired
	PatronRemoveAPIResponseBuilder patronRemoveAPIResponseBuilder;

	@GetMapping("")
	private ResponseMessage<PatronsListInquiryAPIResponse> getAllPatrons() throws AppException {
		PatronsListInquiryCommand patronsListInquiryCommand = patronsListInquiryCommandBuilder
				.buildServiceInput(new PatronsListInquiryResource());
		PatronsListInquiryResponse patronsListInquiryResponse = patronsManage.getAllPatrons(patronsListInquiryCommand);
		return patronsListInquiryAPIResponseBuilder.buildServiceOutput(patronsListInquiryResponse);
	}

	@GetMapping("/{id}")
	private ResponseMessage<PatronInquiryAPIResponse> getPatron(@NotBlank @PathVariable("id") String id)
			throws AppException {
		PatronInquiryResource patronInquiryResource = new PatronInquiryResource(id);
		PatronInquiryCommand patronInquiryCommand = patronInquiryCommandBuilder
				.buildServiceInput(patronInquiryResource);
		PatronInquiryResponse patronInquiryResponse = patronsManage.getPatronById(patronInquiryCommand);
		return patronInquiryAPIResponseBuilder.buildServiceOutput(patronInquiryResponse);
	}

	@PostMapping("")
	private ResponseMessage<PatronCreateAPIResponse> addPatron(@Valid @RequestBody PatronCreateResource request)
			throws AppException {
		PatronCreateCommand patronCreateCommand = patronCreateCommandBuilder.buildServiceInput(request);
		PatronCreateResponse patronCreateResponse = patronsManage.addPatron(patronCreateCommand);
		return patronCreateAPIResponseBuilder.buildServiceOutput(patronCreateResponse);
	}

	@PutMapping("/{id}")
	private ResponseMessage<PatronUpdateAPIResponse> updatePatronById(@NotBlank @PathVariable("id") String id,
			@Valid @RequestBody com.example.mypkg.inbound.domain.resources.Patron patron) throws AppException {
		PatronUpdateResource patronUpdateResource = new PatronUpdateResource(id, patron);
		PatronUpdateCommand patronUpdateCommand = patronUpdateCommandBuilder.buildServiceInput(patronUpdateResource);
		PatronUpdateResponse patronUpdateResponse = patronsManage.updatePatron(patronUpdateCommand);
		return patronUpdateAPIResponseBuilder.buildServiceOutput(patronUpdateResponse);
	}

	@DeleteMapping("/{id}")
	private ResponseMessage<PatronRemoveAPIResponse> deletePatron(@NotBlank @PathVariable("id") String id)
			throws AppException {
		PatronRemoveResource patronRemoveResource = new PatronRemoveResource(id);
		PatronRemoveCommand patronRemoveCommand = patronRemoveCommandBuilder.buildServiceInput(patronRemoveResource);
		PatronRemoveResponse patronRemoveResponse = patronsManage.deletePatron(patronRemoveCommand);
		return patronRemoveAPIResponseBuilder.buildServiceOutput(patronRemoveResponse);
	}

}
