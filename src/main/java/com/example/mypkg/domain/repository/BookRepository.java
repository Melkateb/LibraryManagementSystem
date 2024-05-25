/**
 * 
 */
package com.example.mypkg.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Book;

/**
 * @author MRKAT
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
