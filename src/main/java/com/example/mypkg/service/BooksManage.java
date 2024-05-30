/**
 * 
 */
package com.example.mypkg.service;

import org.springframework.stereotype.Service;

import com.example.mypkg.domain.exceptions.AppException;
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

/**
 * @author MRKAT
 *
 */
@Service
public interface BooksManage {

	public BooksListInquiryResponse getAllBooks(BooksListInquiryCommand booksListInquiryCommand) throws AppException;

	public BookInquiryResponse getBookById(BookInquiryCommand bookInquiryCommand) throws AppException;

	public BookCreateResponse addBook(BookCreateCommand bookCreateCommand) throws AppException;

	public BookUpdateResponse updateBook(BookUpdateCommand bookUpdateCommand) throws AppException;

	public BookRemoveResponse deleteBook(BookRemoveCommand bookRemoveCommand) throws AppException;
}
