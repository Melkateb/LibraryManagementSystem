/**
 * 
 */
package com.example.mypkg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Book;

/**
 * @author MRKAT
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
