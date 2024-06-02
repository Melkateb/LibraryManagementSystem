/**
 * 
 */
package com.example.mypkg.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Repository
public interface PatronRepository extends CrudRepository<Patron, String> {

	@Query("SELECT p FROM Patron p WHERE p.name = :name AND p.mobile = :mobile")
	Optional<Patron> findByNameAndMobile(String name, String mobile);
}
