package de.nak.studentsdatabase.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

/**
 * Entity of a company.
 *
 * @author Andreas Krey
 */

@Entity
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
	private List<String> contact = new ArrayList<String>();
	/** The address of a company */
	private Address address;
	/** The set of associated students. */
	private Set<Student> students;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
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
	@Column(length = 100, nullable = false)
	public String getAddition() {
		return addition;
	}
	
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
	public List<String> getContact() {
	    return contact;
	}
	
	public void setContact(List<String> contact) {
		this.contact = contact;
	}
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany//(mappedBy = "COMPANY")
	@JoinColumn(name = "STUDENT_ID")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	/**
	 * Associates the given student to this company.
	 * @param student The student to associate.
	 */
	public void associateStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		if (this.equals(student.getCompany())) {
			// The same company is already associated
			return;
		}
		if (student.getCompany() != null) {
			student.getCompany().getStudents().remove(student);
		}
		student.setCompany(this);
		this.students.add(student);
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
		final Company other = (Company) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (name != other.name)
			return false;
		return true;
	}
	
	
}
