package de.nak.studentsdatabase.model;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;


/**
 * Entity of a manipel.
 *
 * @author Andreas Krey
 */

@Entity
public class Manipel {
	/** The identifier. */
	private Long id;
	/** The course of study. */
	private String courseOfStudy;
	/** The vintage of a manipel. */
	private Integer vintage;
	/** The set of zenturie's of a manipel. */
	private Set<Zenturie> zenturies;
	/** The set of exams of a manipel. */
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
	@Column(name= "course_of_study",length = 100, nullable = false)
	public String getCourseOfStudy() {
		return courseOfStudy;
	}
	
	public void setCourseOfStudy(String courseOfStudy) {
		this.courseOfStudy = courseOfStudy;
	}
	
	@NaturalId
	@Column(length = 4, nullable = false)
	public Integer getVintage() {
		return vintage;
	}
	
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}

	@OneToMany//(mappedBy = "MANIPEL")
	@JoinColumn(name = "ZENTURIE_ID")
	public Set<Zenturie> getZenturies() {
		return zenturies;
	}

	public void setZenturies(Set<Zenturie> zenturies) {
		this.zenturies = zenturies;
	}

	/**
	 * Associates the given zenturie to this manipel.
	 * @param zenturie The zenturie to associate.
	 */
	public void associateZenturie(Zenturie zenturie) {
		if (zenturie == null) {
			throw new IllegalArgumentException();
		}
		if (this.equals(zenturie.getManipel())) {
			// The same manipel is already associated
			return;
		}
		if (zenturie.getManipel() != null) {
			zenturie.getManipel().getZenturies().remove(zenturie);
		}
		zenturie.setManipel(this);
		this.zenturies.add(zenturie);
	}
	
	@ManyToMany
	@JoinTable(name="MANIPEL_EXAM", joinColumns={ @JoinColumn(name="MANIPEL_ID")},
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
		result = prime * result + vintage;
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
		final Manipel other = (Manipel) obj;
		if (courseOfStudy == null) {
			if (other.courseOfStudy != null)
				return false;
		} else if (!courseOfStudy.equals(other.courseOfStudy))
			return false;
		if (vintage != other.vintage)
			return false;
		return true;
	}

}
