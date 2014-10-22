package de.nak.studentsdatabase.model;

import java.util.GregorianCalendar;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;


/**
 * Entity of a student.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "STUDENT")
public class Student {
	/** The identifier. */
	private Long id;
	/** The matriculation number of a student. */
	private Integer matriculationNumber;
	/** The user identification of a student. */
	private Integer userIdentification;
	/** The last name of a student. */
	private String name;
	/** The forename of a student. */
	private String forename;
	/** The salutation of a student. */
	private String salutation;
	/** The gender of a student. */
	private String gender;
	/** The day of birth of a student. */
	private GregorianCalendar dayOfBirth;
	/** The place of birth of a student. */
	private String placeOfBirth;
	/** The status of a student. */
	private Boolean status;
	/** The address of a student. */
	private Address address;
	/** The company of a student. */
	private Company company;
	/** The manipel of a student. */
	private Manipel manipel;
	/** The name of exam of a student. */
	private String exam;
	/** The set of associated exams. */
	private Set<Exam> exams;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	@NaturalId
	@Column(length = 10, nullable = false)
	public Integer getMatriculationNumber() {
		return matriculationNumber;
	}
	
	public void setMatriculationNumber(Integer matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}
	
	@Column(length = 100, nullable = false)
	public Integer getUserIdentification() {
		return userIdentification;
	}
	public void setUserIdentification(Integer userIdentification) {
		this.userIdentification = userIdentification;
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
	public GregorianCalendar getDayOfBirth() {
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
	@JoinColumn(name = "ADDRESS_ID")
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
	
	@Column(length = 100, nullable = true)
	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}
	
	
	/**
	 * Associates the given exam to this student.
	 * @param exam The exam to associate.
	 */
	public void associateExam(Exam exam) {
		if (exam == null) {
			throw new IllegalArgumentException();
		}
		if (this.equals(exam.getStudent())) {
			// The same student is already associated
			return;
		}
		if (exam.getStudent() != null) {
			exam.getStudent().getExams().remove(exam);
		}
		exam.setStudent(this);
		this.exams.add(exam);
	}
	
	@OneToMany(mappedBy = "STUDENT")
	public Set<Exam> getExams() {
		return exams;
	}

	/**
	 * Sets the set of associated exams.
	 * @param exams the exams to set.
	 */
	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}



}
