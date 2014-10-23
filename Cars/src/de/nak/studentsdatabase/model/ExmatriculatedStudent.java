package de.nak.studentsdatabase.model;


import javax.persistence.*;


/**
 * Entity of an exmatriculated student.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "EXMATRICULATEDSTUDENT")
public class ExmatriculatedStudent extends Student {
	/** The identifier. */
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

}
