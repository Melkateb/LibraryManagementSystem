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
import com.example.mypkg.domain.exceptions.BookAlreadyExistsException;
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
	public BooksListInquiryResponse getAllBooks(BooksListInquiryCommand booksListInquiryCommand)
			throws ApplicationException {
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(book -> books.add(book));
		return new BooksListInquiryResponse(books);
	}

	@Override
	public BookInquiryResponse getBookById(BookInquiryCommand bookInquiryCommand) throws ApplicationException {
		// Check that book exists and get it
		Book book = getBook(bookInquiryCommand.getId());
		return new BookInquiryResponse(book);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BookCreateResponse addBook(BookCreateCommand bookCreateCommand) throws ApplicationException {
		// Check that no book with same title and author
		validateBookExistance(bookCreateCommand.getTitle(), bookCreateCommand.getAuthor());

		// Add new book
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
	public BookUpdateResponse updateBook(BookUpdateCommand bookUpdateCommand) throws ApplicationException {

		// Check that there is no another book with same title and author
		validateBookExistance(bookUpdateCommand.getBook().getTitle(), bookUpdateCommand.getBook().getAuthor());

		// Get book
		Book book = getBook(bookUpdateCommand.getId());

		// Update book
		book.setTitle(bookUpdateCommand.getBook().getTitle());
		book.setAuthor(bookUpdateCommand.getBook().getAuthor());
		book.setPublicationYear(bookUpdateCommand.getBook().getPublicationYear());
		book.setIsbn(bookUpdateCommand.getBook().getIsbn());
		bookRepository.save(book);
		return new BookUpdateResponse();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BookRemoveResponse deleteBook(BookRemoveCommand bookRemoveCommand) throws ApplicationException {

		// Check that book exists
		Book book = getBook(bookRemoveCommand.getId());

		// Delete book
		bookRepository.deleteById(bookRemoveCommand.getId());
		return new BookRemoveResponse();
	}

	private Book getBook(String bookId) throws BookNotFoundException {
		// Check that book exists
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException();
		}
		return optionalBook.get();
	}

	private void validateBookExistance(String title, String author) throws BookAlreadyExistsException {
		// Check that book exists
		Optional<Book> optionalBook = bookRepository.findByTitleAndAuthor(title, author);
		if (optionalBook.isPresent()) {
			throw new BookAlreadyExistsException();
		}
	}
}
