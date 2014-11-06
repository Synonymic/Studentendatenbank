package de.nak.studentsdatabase.model;

import javax.persistence.*;

/**
 * Entity of an applicant.
 *
 * @author Andreas Krey
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Applicant {
	/** The identifier. */
	private Long id;
	/** The  last name of an applicant. */
	private String name;
	/** The first name of an applicant. */
	private String firstName;
	/** The salutation of an applicant. */
	private String salutation;
	/** The gender of an applicant. */
	private String gender;
	/** The day of birth of an applicant. */
	private String dayOfBirth;
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
	@Column(name="first_name",length = 100, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	@Column(name="day_of_birth",length = 10, nullable = false)
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	@Column(name="place_of_birth",length = 100, nullable = true)
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	
	@OneToOne (cascade=CascadeType.DETACH)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

}
