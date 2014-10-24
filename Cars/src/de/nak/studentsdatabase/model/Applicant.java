package de.nak.studentsdatabase.model;

import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Entity of an applicant.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "APPLICANT")
@Inheritance(strategy=InheritanceType.JOINED)
public class Applicant {
	/** The identifier. */
	private Long id;
	/** The  last name of an applicant. */
	private String name;
	/** The forename of an applicant. */
	private String forename;
	/** The salutation of an applicant. */
	private String salutation;
	/** The gender of an applicant. */
	private String gender;
	/** The day of birth of an applicant. */
	private GregorianCalendar dayOfBirth;
	/** The place of birth of an applicant. */
	private String placeOfBirth;
	/** The address of an applicant. */
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
	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	@Column(length = 100, nullable = false)
	public String getSalutation() {
		return salutation;
	}
	
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	@Column(length = 100, nullable = false)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(length = 10, nullable = false)
	public GregorianCalendar getDayOfBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(GregorianCalendar dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	@Column(length = 100, nullable = true)
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
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
