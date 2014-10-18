package de.nak.studentendatenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Die Pr�fungsentit�t.
 * @author Andreas Krey
 */
@Entity
@Table(name = "Pruefung")
public class Pruefung {
	/** Die eindeutige Identifikation. */
	private Long id;
	/** Der Name einer Pr�fung. */
	private String name;
	/** Die Note einer Pr�fung. */
	private Integer note;
	/** Der Student einer Pr�fung. */
	private Student student;
	
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
	public Integer getNote() {
		return note;
	}
	
	public void setNote(Integer note) {
		this.note = note;
	}
	
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	

}
