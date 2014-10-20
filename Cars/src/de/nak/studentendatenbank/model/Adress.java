package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * Adress entity.
 *
 * @author Andreas Krey
 */

@Entity 
@Table(name= "ADRESS")
public class Adress {
	/** The identifier. */
	private Long id;
	/** The addition of an adress. */
	private String addition;
	/** The street name of an adress. */
	private String street;
	/** The postcode of a city. */
	private Integer postcode;
	/** The name of the city. */
	private String city;
	/** The telephone number. */
	private Integer number;
	/** The fax number. */
	private Integer fax;
	/** The e-mail adress. */
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
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
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
	
}
