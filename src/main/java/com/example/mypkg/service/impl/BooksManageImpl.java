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
import com.example.mypkg.domain.exceptions.BookNotFoundException;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.inbound.command.BookCreateCommand;
import com.example.mypkg.inbound.command.BookInquiryCommand;
import com.example.mypkg.inbound.command.BookRemoveCommand;
import com.example.mypkg.inbound.command.BookUpdateCommand;
import com.example.mypkg.inbound.command.BooksListInquiryCommand;
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
@Service
public class BooksManageImpl implements BooksManage {

	@Autowired
	BookRepository bookRepository;

	@Override
	public BooksListInquiryResponse getAllBooks(BooksListInquiryCommand booksListInquiryCommand) throws AppException {
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(book -> books.add(book));
		return new BooksListInquiryResponse(books);
	}

	@Override
	public BookInquiryResponse getBookById(BookInquiryCommand bookInquiryCommand) throws AppException {
		// TODO handle that book doesn't exists
		Optional<Book> optionalBook = bookRepository.findById(bookInquiryCommand.getId());
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException();
		}
		return new BookInquiryResponse(optionalBook.get());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BookCreateResponse addBook(BookCreateCommand bookCreateCommand) throws AppException {
		// TODO check that book already exists
		Book book = new Book();
		book.setTitle(bookCreateCommand.getTitle());
		book.setAuthor(bookCreateCommand.getAuthor());
		book.setPublicationYear(bookCreateCommand.getPublicationYear());
		book.setIsbn(bookCreateCommand.getIsbn());
		bookRepository.save(book);
		return new BookCreateResponse(book.getId());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BookUpdateResponse updateBook(BookUpdateCommand bookUpdateCommand) throws AppException {
		Book book = bookRepository.findById(bookUpdateCommand.getId()).get();
		book.setTitle(bookUpdateCommand.getBook().getTitle());
		book.setAuthor(bookUpdateCommand.getBook().getAuthor());
		book.setPublicationYear(bookUpdateCommand.getBook().getPublicationYear());
		book.setIsbn(bookUpdateCommand.getBook().getIsbn());
		// TODO handle comming id
		// TODO handle that book doesn't exists
		bookRepository.save(book);
		return new BookUpdateResponse();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BookRemoveResponse deleteBook(BookRemoveCommand bookRemoveCommand) throws AppException {
		// TODO handle that book doesn't exists
		bookRepository.deleteById(bookRemoveCommand.getId());
		return new BookRemoveResponse();
	}
}
