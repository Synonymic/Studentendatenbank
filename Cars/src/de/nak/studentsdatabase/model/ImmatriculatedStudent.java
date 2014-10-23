package de.nak.studentsdatabase.model;


import javax.persistence.*;


/**
 * Entity of an immatriculated student.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "IMMATRICULATEDSTUDENT")
public class ImmatriculatedStudent extends Student{
	/** The identifier. */
	private Long id;
	/** The user identification for university systems of an immatriculated student. */
	private Integer userIdentification;
	/** The zenturie of an immatriculated student */
	private Zenturie zenturie;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = false)
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
