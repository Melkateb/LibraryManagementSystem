/**
 * 
 */
package com.example.mypkg.domain.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */
@Entity
@Table(name = "BORROWING_RECORD")
public class BorrowingRecord {
	
	@Column(name = "ID", unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "NAME")
	private String name;
	
	
}
