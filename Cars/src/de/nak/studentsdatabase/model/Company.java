package de.nak.studentsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity of a company.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "COMPANY")
public class Company {
	/** The identifier. */
	private Long id;
	/** The name of a company. */
	private String name;
	/** The addition of a company. */
	private String addition;
	/** The abbreviation of a company. */
	private String abbreviation;
	/** The contact of a company. */
	private String contact;
	/** The address of a company */
	private Address address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 100, nullable = false)
	public String getAddition() {
		return addition;
	}
	
	@Column(length = 100, nullable = false)
	public void setAddition(String addition) {
		this.addition = addition;
	}
	
	@Column(length = 20, nullable = false)
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	@Column(length = 100, nullable = false)
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@OneToOne
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
