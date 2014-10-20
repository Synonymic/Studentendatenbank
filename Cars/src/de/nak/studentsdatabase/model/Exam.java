package de.nak.studentsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity of exam.
 * @author Andreas Krey
 */
@Entity
@Table(name = "EXAM")
public class Exam {
	/** The identifier. */
	private Long id;
	/** The name of an exam. */
	private String name;
	/** The grade of an exam. */
	private Integer grade;
	/** The student of an exam. */
	private Student student;
	/** The zenturie of an exam. **/
	private Zenturie zenturie;
	/** The manipel of an exam. **/
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
	
	@Column(length = 3, nullable = false)	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "ZENTURIE_ID")
	public Zenturie getZenturie() {
		return zenturie;
	}

	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
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
