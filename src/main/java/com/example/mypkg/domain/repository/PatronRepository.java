/**
 * 
 */
package com.example.mypkg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.domain.model.Patron;

/**
 * @author MRKAT
 *
 */
@Repository
public interface PatronRepository  extends JpaRepository<Patron, String> {

}
