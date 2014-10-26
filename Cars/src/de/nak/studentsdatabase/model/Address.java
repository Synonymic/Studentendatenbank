package de.nak.studentsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * Address entity.
 *
 * @author Andreas Krey
 */

@Entity 
@Table(name= "Address")
public class Address {
	/** The identifier. */
	private Long id;
	/** The addition of an address. */
	private String addition;
	/** The street name of an address. */
	private String street;
	/** The house number of an address. */
	private String houseNumber;
	/** The postcode of a city. */
	private Integer postcode;
	/** The name of the city. */
	private String city;
	/** The telephone number. */
	private Integer telephoneNumber;
	/** The fax number. */
	private Integer fax;
	/** The e-mail address. */
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = true)
	public String getAddition() {
		return addition;
	}
	
	public void setAddition(String addition) {
		this.addition = addition;
	}
	
	@Column(length = 100, nullable = false)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@NaturalId
	@Column(length = 5, nullable = false)
	public Integer getPostcode() {
		return postcode;
	}
	
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}
	
	@NaturalId
	@Column(length = 100, nullable = false)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length = 100, nullable = false)
	public Integer getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(Integer telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	@Column(length = 100, nullable = true)
	public Integer getFax() {
		return fax;
	}
	
	public void setFax(Integer fax) {
		this.fax = fax;
	}
	
	@Column(length = 100, nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 100, nullable = false)
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	
	
}
