/**
 * 
 */
package com.example.mypkg.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.ApplicationException;
import com.example.mypkg.domain.exceptions.BookAlreadyBookedException;
import com.example.mypkg.domain.exceptions.BookNotFoundException;
import com.example.mypkg.domain.exceptions.BorrowingRecordAlreadyExistsException;
import com.example.mypkg.domain.exceptions.BorrowingRecordNotFoundException;
import com.example.mypkg.domain.exceptions.PatronNotFoundException;
import com.example.mypkg.domain.model.Book;
import com.example.mypkg.domain.model.BorrowingRecord;
import com.example.mypkg.domain.model.Patron;
import com.example.mypkg.domain.repository.BookRepository;
import com.example.mypkg.domain.repository.BorrowingRecordRepository;
import com.example.mypkg.domain.repository.PatronRepository;
import com.example.mypkg.inbound.command.BorrowingRecordCreateCommand;
import com.example.mypkg.inbound.command.BorrowingRecordUpdateCommand;
import com.example.mypkg.outbound.response.BorrowingRecordCreateResponse;
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

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PatronRepository patronRepository;

	@Override
	public BorrowingRecordCreateResponse addBorrowingRecord(BorrowingRecordCreateCommand borrowingRecordCreateCommand)
			throws ApplicationException {

		// Check that patron exists
		Patron patron = getPatron(borrowingRecordCreateCommand.getPatronId());

		// Check that book exists
		Book book = getBook(borrowingRecordCreateCommand.getBookId());

		// Check that book record doesn't exist
		validateBorrowingRecord(borrowingRecordCreateCommand.getBookId(), borrowingRecordCreateCommand.getPatronId());

		// Check that not borrowed by another patron
		if (book.getIsBorrowed()) {
			throw new BookAlreadyBookedException();
		}

		// Create borrowing record
		BorrowingRecord borrowingRecord = createBorrowingrecord(borrowingRecordCreateCommand.getBookId(),
				borrowingRecordCreateCommand.getPatronId());
		borrowingRecordRepository.save(borrowingRecord);

		// Update book to be borrowed
		book.setIsBorrowed(true);
		bookRepository.save(book);

		// Add book to borrowed books list
		patron.addToBorrowedBooks(book.getId());
		patronRepository.save(patron);

		return new BorrowingRecordCreateResponse(borrowingRecord.getId());
	}

	@Override
	public BorrowingRecordUpdateResponse updateBorrowingRecord(
			BorrowingRecordUpdateCommand borrowingRecordUpdateCommand) throws ApplicationException {

		// Get book
		Book book = getBook(borrowingRecordUpdateCommand.getBookId());

		// Check that patron exists
		Patron patron = getPatron(borrowingRecordUpdateCommand.getPatronId());

		// Check that book record exist
		BorrowingRecord borrowingRecord = getBorrowingRecord(borrowingRecordUpdateCommand.getBookId(),
				borrowingRecordUpdateCommand.getPatronId());

		borrowingRecord.setReturnDate(new Date());
		borrowingRecordRepository.save(borrowingRecord);

		// Update book to be not borrowed
		book.setIsBorrowed(false);
		bookRepository.save(book);

		// remove borrowed book from patron borrowed book list
		patron.removeFromBorrowedBooks(book.getId());
		patronRepository.save(patron);

		return new BorrowingRecordUpdateResponse(borrowingRecord.getBorrowDate(), borrowingRecord.getReturnDate());
	}

	private Patron getPatron(String patronId) throws PatronNotFoundException {
		Optional<Patron> optionalPatron = patronRepository.findById(patronId);
		if (!optionalPatron.isPresent()) {
			throw new PatronNotFoundException();
		}
		return optionalPatron.get();
	}

	private Book getBook(String bookId) throws BookNotFoundException {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException();
		}
		return optionalBook.get();
	}

	private void validateBorrowingRecord(String bookId, String patronId) throws BorrowingRecordAlreadyExistsException {
		Optional<BorrowingRecord> optionalBorrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId,
				patronId);
		if (optionalBorrowingRecord.isPresent()) {
			throw new BorrowingRecordAlreadyExistsException();
		}
	}

	private BorrowingRecord getBorrowingRecord(String bookId, String patronId) throws BorrowingRecordNotFoundException {
		Optional<BorrowingRecord> optionalBorrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId,
				patronId);
		if (!optionalBorrowingRecord.isPresent()) {
			throw new BorrowingRecordNotFoundException();
		}
		return optionalBorrowingRecord.get();
	}

	private BorrowingRecord createBorrowingrecord(String bookId, String patronId) {
		BorrowingRecord borrowingRecord = new BorrowingRecord();
		borrowingRecord.setBookId(bookId);
		borrowingRecord.setPatronId(patronId);
		borrowingRecord.setBorrowDate(new Date());
		return borrowingRecord;

	}

}
