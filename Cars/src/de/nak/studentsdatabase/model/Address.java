package de.nak.studentsdatabase.model;

import javax.persistence.*;

/**
 * Address entity.
 *
 * @author Andreas Krey
 */

@Entity 
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
	private String postcode;
	/** The name of the city. */
	private String city;
	/** The telephone number. */
	private String telephoneNumber;
	/** The fax number. */
	private String fax;
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
	
	
	@Column(length = 5, nullable = false)
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	@Column(length = 100, nullable = false)
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="telephone_number",length = 100, nullable = false)
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	@Column(length = 100, nullable = true)
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Column(length = 100, nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="house_number",length = 100, nullable = false)
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	
	
}
