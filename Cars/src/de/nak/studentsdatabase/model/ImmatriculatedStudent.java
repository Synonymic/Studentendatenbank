package de.nak.studentsdatabase.model;


import javax.persistence.*;


/**
 * Entity of an immatriculated student.
 *
 * @author Andreas Krey
 */
@Entity
@PrimaryKeyJoinColumn(name="STUDENT_ID")
public class ImmatriculatedStudent extends Student{
	/** The user identification for university systems of an immatriculated student. */
	private Integer userIdentification;
	/** The zenturie of an immatriculated student */
	private Zenturie zenturie;
	
	@Column(name= "user_identification",length = 100, nullable = false)
	public Integer getUserIdentification() {
		return userIdentification;
	}
	
	public void setUserIdentification(Integer userIdentification) {
		this.userIdentification = userIdentification;
	}
	
	@ManyToOne
	@JoinColumn(name = "ZENTURIE_ID")
	public Zenturie getZenturie() {
		return zenturie;
	}

	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
	}

}
