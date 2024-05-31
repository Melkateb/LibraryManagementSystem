/**
 * 
 */
package com.example.mypkg.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.BorrowingRecord;

/**
 * @author MRKAT
 *
 */
@Repository
public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord, String> {

	@Query("SELECT br FROM BorrowingRecord br WHERE br.bookId = :bookId AND br.patronId = :patronId")
	Optional<BorrowingRecord> findByBookIdAndPatronId(String bookId, String patronId);

}
