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
import com.example.mypkg.inbound.command.BookCreateCommand;
import com.example.mypkg.inbound.command.BookInquiryCommand;
import com.example.mypkg.inbound.command.BookRemoveCommand;
import com.example.mypkg.inbound.command.BookUpdateCommand;
import com.example.mypkg.inbound.command.BooksListInquiryCommand;
import com.example.mypkg.inbound.converter.BookCreateCommandBuilder;
import com.example.mypkg.inbound.converter.BookInquiryCommandBuilder;
import com.example.mypkg.inbound.converter.BookRemoveCommandBuilder;
import com.example.mypkg.inbound.converter.BookUpdateCommandBuilder;
import com.example.mypkg.inbound.converter.BooksListInquiryCommandBuilder;
import com.example.mypkg.inbound.resources.BookCreateResource;
import com.example.mypkg.inbound.resources.BookInquiryResource;
import com.example.mypkg.inbound.resources.BookRemoveResource;
import com.example.mypkg.inbound.resources.BookUpdateResource;
import com.example.mypkg.inbound.resources.BooksListInquiryResource;
import com.example.mypkg.outbound.api.response.BookCreateAPIResponse;
import com.example.mypkg.outbound.api.response.BookInquiryAPIResponse;
import com.example.mypkg.outbound.api.response.BookRemoveAPIResponse;
import com.example.mypkg.outbound.api.response.BookUpdateAPIResponse;
import com.example.mypkg.outbound.api.response.BooksListInquiryAPIResponse;
import com.example.mypkg.outbound.converter.BookCreateAPIResponseBuilder;
import com.example.mypkg.outbound.converter.BookInquiryAPIResponseBuilder;
import com.example.mypkg.outbound.converter.BookRemoveAPIResponseBuilder;
import com.example.mypkg.outbound.converter.BookUpdateAPIResponseBuilder;
import com.example.mypkg.outbound.converter.BooksListInquiryAPIResponseBuilder;
import com.example.mypkg.outbound.response.BookCreateResponse;
import com.example.mypkg.outbound.response.BookInquiryResponse;
import com.example.mypkg.outbound.response.BookRemoveResponse;
import com.example.mypkg.outbound.response.BookUpdateResponse;
import com.example.mypkg.outbound.response.BooksListInquiryResponse;
import com.example.mypkg.service.BooksManage;

/**
 * @author MRKAT
 *
 */
@RestController
@RequestMapping("/api/books")
public class BooksManageController {

	@Autowired
	BooksManage booksManage;

	@Autowired
	BooksListInquiryCommandBuilder booksListInquiryCommandBuilder;

	@Autowired
	BooksListInquiryAPIResponseBuilder booksListInquiryAPIResponseBuilder;

	@Autowired
	BookCreateCommandBuilder bookCreateCommandBuilder;

	@Autowired
	BookCreateAPIResponseBuilder bookCreateAPIResponseBuilder;

	@Autowired
	BookUpdateCommandBuilder bookUpdateCommandBuilder;

	@Autowired
	BookUpdateAPIResponseBuilder bookUpdateAPIResponseBuilder;

	@Autowired
	BookInquiryCommandBuilder bookInquiryCommandBuilder;

	@Autowired
	BookInquiryAPIResponseBuilder bookInquiryAPIResponseBuilder;

	@Autowired
	BookRemoveCommandBuilder bookRemoveCommandBuilder;

	@Autowired
	BookRemoveAPIResponseBuilder bookRemoveAPIResponseBuilder;

	@GetMapping("")
	private ResponseMessage<BooksListInquiryAPIResponse> getAllBook() throws AppException {
		BooksListInquiryCommand booksListInquiryCommand = booksListInquiryCommandBuilder
				.buildServiceInput(new BooksListInquiryResource());
		BooksListInquiryResponse booksListInquiryResponse = booksManage.getAllBooks(booksListInquiryCommand);
		return booksListInquiryAPIResponseBuilder.buildServiceOutput(booksListInquiryResponse);
	}

	@GetMapping("/{id}")
	private ResponseMessage<BookInquiryAPIResponse> getBook(@NotBlank @PathVariable("id") String id)
			throws AppException {
		BookInquiryResource bookInquiryResource = new BookInquiryResource(id);
		BookInquiryCommand bookInquiryCommand = bookInquiryCommandBuilder.buildServiceInput(bookInquiryResource);
		BookInquiryResponse bookInquiryResponse = booksManage.getBookById(bookInquiryCommand);
		return bookInquiryAPIResponseBuilder.buildServiceOutput(bookInquiryResponse);
	}

	@PostMapping("")
	private ResponseMessage<BookCreateAPIResponse> addBook(@Valid @RequestBody BookCreateResource request)
			throws AppException {
		BookCreateCommand bookCreateCommand = bookCreateCommandBuilder.buildServiceInput(request);
		BookCreateResponse bookCreateResponse = booksManage.addBook(bookCreateCommand);
		return bookCreateAPIResponseBuilder.buildServiceOutput(bookCreateResponse);
	}

	@PutMapping("/{id}")
	private ResponseMessage<BookUpdateAPIResponse> updateBookById(@NotBlank @PathVariable("id") String id,
			@Valid @RequestBody com.example.mypkg.inbound.domain.resources.Book book) throws AppException {
		BookUpdateResource bookUpdateResource = new BookUpdateResource(id, book);
		BookUpdateCommand bookUpdateCommand = bookUpdateCommandBuilder.buildServiceInput(bookUpdateResource);
		BookUpdateResponse bookUpdateResponse = booksManage.updateBook(bookUpdateCommand);
		return bookUpdateAPIResponseBuilder.buildServiceOutput(bookUpdateResponse);
	}

	@DeleteMapping("/{id}")
	private ResponseMessage<BookRemoveAPIResponse> deleteBook(@NotBlank @PathVariable("id") String id)
			throws AppException {
		BookRemoveResource bookRemoveResource = new BookRemoveResource(id);
		BookRemoveCommand bookRemoveCommand = bookRemoveCommandBuilder.buildServiceInput(bookRemoveResource);
		BookRemoveResponse bookRemoveResponse = booksManage.deleteBook(bookRemoveCommand);
		return bookRemoveAPIResponseBuilder.buildServiceOutput(bookRemoveResponse);
	}

}
