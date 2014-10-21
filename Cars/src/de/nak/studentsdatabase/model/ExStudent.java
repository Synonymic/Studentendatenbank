package de.nak.studentsdatabase.model;

import java.util.GregorianCalendar;

import javax.persistence.*;


/**
 * Entity of an exmatriculated student.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "EXSTUDENT")
public class ExStudent {
	/** The identifier. */
	private Long id;

	/** The last name of an exmatriculated student. */
	private String name;
	/** The forename of an exmatriculated student. */
	private String forename;
	/** The salutation of an exmatriculated student. */
	private String salutation;
	/** The gender of an exmatriculated student. */
	private String gender;
	/** The day of birth of an exmatriculated student. */
	private GregorianCalendar dayOfBirth;
	/** The place of birth of an exmatriculated student. */
	private String placeOfBirth;
	/** The status of an exmatriculated student. */
	private Boolean status;
	/** The address of an exmatriculated student. */
	private Address address;
	/** The company of an exmatriculated student. */
	private Company company;
	/** The manipel of an exmatriculated student. */
	private Manipel manipel;
	
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
	
	@Column(length = 4, nullable = false)
	public String getSalutation() {
		return salutation;
	}
	
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	@Column(length = 10, nullable = false)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(length = 10, nullable = false)
	public GregorianCalendar getDayofBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(GregorianCalendar dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	@Column(length = 100, nullable = false)
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	
	@Column(length = 100, nullable = false)
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@OneToOne
	@JoinColumn(name = "ADRESS_ID")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@ManyToOne
	@JoinColumn(name = "MANIPEL_ID")
	public Manipel getManipel() {
		return manipel;
	}
	
	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

}
