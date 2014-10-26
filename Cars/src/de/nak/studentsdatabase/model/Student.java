package de.nak.studentsdatabase.model;

import java.util.Set;

import javax.persistence.*;



/**
 * Entity of a student.
 *
 * @author Andreas Krey
 */
@Entity
@PrimaryKeyJoinColumn(name="APPLICANT_ID")

public class Student extends Applicant{
//	/** The identifier. */
//	private Long id;
	/** The matriculation number of a student. */
	private Integer matriculationNumber;
	/** The company of a student. */
	private Company company;
	/** The manipel of a student. */
	private Manipel manipel;
	/** The name of exam of a student. */
	private String exam;
	/** The set of associated exams. */
	private Set<Exam> exams;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)	
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
	@Column(length = 10, nullable = false)
	public Integer getMatriculationNumber() {
		return matriculationNumber;
	}
	
	public void setMatriculationNumber(Integer matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
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
	
	
	@ManyToMany
	@JoinTable(name="STUDENT_EXAM", joinColumns={ @JoinColumn(name="STUDENT_ID")},
				inverseJoinColumns={@JoinColumn(name="EXAM_ID") })
	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 11;
		int result = 1;
		result = prime * result + matriculationNumber;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Student other = (Student) obj;
		if (matriculationNumber != other.matriculationNumber)
			return false;
		return true;
	}	


}
