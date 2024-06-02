/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.example.mypkg.utils.SetConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */

@Entity
@Table(name = "PATRON")
public class Patron {

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "BIRTHDATE")
	private Date birthdate;

	@Column(name = "BORROWED_BOOK_IDS")
	@Convert(converter = SetConverter.class)
	private Set<String> borrowedBooks = new HashSet<>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the borrowedBook
	 */
	public Set<String> getBorrowedBook() {
		return borrowedBooks;
	}

	/**
	 * @param borrowedBook the borrowedBook to set
	 */
	public void setBorrowedBooks(Set<String> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public void addToBorrowedBooks(String book) {
		this.borrowedBooks.add(book);
	}

	public void removeFromBorrowedBooks(String book) {
		this.borrowedBooks.remove(book);
	}

	public Patron() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthdate, borrowedBooks, email, id, mobile, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patron other = (Patron) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(borrowedBooks, other.borrowedBooks) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", mobile=" + mobile + ", address=" + address + ", email="
				+ email + ", birthdate=" + birthdate + ", borrowedBooks=" + borrowedBooks + "]";
	}

}
