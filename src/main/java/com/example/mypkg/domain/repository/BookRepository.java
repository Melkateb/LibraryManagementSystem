/**
 * 
 */
package com.example.mypkg.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Book;

/**
 * @author MRKAT
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

	@Query("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author")
	Optional<Book> findByTitleAndAuthor(String title, String author);

	@Query("SELECT b FROM Book b WHERE b.id IN(:bookIds)")
	List<Book> getBorrowedBooks(Set<String> bookIds);

}
