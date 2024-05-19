/**
 * 
 */
package com.example.mypkg.domain.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author MRKAT
 *
 */

@Entity
@Table(name = "PATRON")
public class Patron {
	
	@Column(name = "ID", unique = true)
	private String id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTACT_INFORMATION")
	private String contactInformation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public Patron() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactInformation, id, name);
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
		return Objects.equals(contactInformation, other.contactInformation) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", contactInformation=" + contactInformation + "]";
	}
	
}
