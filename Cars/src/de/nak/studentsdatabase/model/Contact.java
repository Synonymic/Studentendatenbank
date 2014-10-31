package de.nak.studentsdatabase.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

/**
 * Entity of a student's contact in company.
 * 
 * @author Andreas Krey
 */

@Entity
public class Contact {
	/** The identifier. */
	private Long id;
	/** The last name of a contact. */
	private String name;
	/** The first name of a contact. */
	private String firstName;
	/** The associated company. */
	private Company company;
	/** The set of associated students */;
	private Set<Student> students;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="contact_id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	@NaturalId
	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@NaturalId
	@Column(name="first_name",length = 100, nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@OneToMany(mappedBy = "contact")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
