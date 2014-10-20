package de.nak.studentsdatabase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity of a zenturie.
 *
 * @author Andreas Krey
 */

@Entity
@Table(name= "ZENTURIE")
public class Zenturie {
	/** The identifier. */
	private Long id;
	/** The name of a zenturie. */
	private String name;
	/** The course of study. */
	private String courseOfStudy;
	
	
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
	public String getCourseOfStudy() {
		return courseOfStudy;
	}
	
	public void setCourseOfStudy(String courseOfStudy) {
		this.courseOfStudy = courseOfStudy;
	}
}
