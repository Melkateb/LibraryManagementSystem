/**
 * 
 */
package com.example.mypkg.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Repository
public interface PatronRepository extends CrudRepository<Patron, String> {

}
