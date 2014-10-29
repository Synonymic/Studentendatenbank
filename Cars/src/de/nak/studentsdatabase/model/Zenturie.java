package de.nak.studentsdatabase.model;


import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;


/**
 * Entity of a zenturie.
 *
 * @author Andreas Krey
 */

@Entity
public class Zenturie {
	/** The identifier. */
	private Long id;
	/** The name of a zenturie. */
	private String name;
	/** The associated manipel of a zenturie. */
	private Manipel manipel;
	/** The associated set of students. */
	private Student students;
	/** The set of associated exams */
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
	@Column(length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@NaturalId
	@ManyToOne
	@JoinColumn(name = "MANIPEL_ID")
	public Manipel getManipel() {
		return manipel;
	}

	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}
	
	@ManyToMany
	@JoinTable(name="ZENTURIE_EXAM", joinColumns={ @JoinColumn(name="ZENTURIE_ID")},
				inverseJoinColumns={@JoinColumn(name="EXAM_ID") })
	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
}
