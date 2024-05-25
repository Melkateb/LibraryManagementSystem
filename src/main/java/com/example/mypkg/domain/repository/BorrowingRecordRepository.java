/**
 * 
 */
package com.example.mypkg.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.BorrowingRecord;

/**
 * @author MRKAT
 *
 */
@Repository
public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord, String> {

}
