package de.nak.studentsdatabase.model;

import javax.persistence.*;


/**
 * Entity of an discontinued student.
 *
 * @author Andreas Krey
 */
@Entity
@Table(name= "Discountedstudent")
@PrimaryKeyJoinColumn(name="STUDENT_ID")
public class DiscontinuedStudent extends Student{
//	/** The identifier. */
//	private Long id;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)	
//	public Long getId() {
//		return id;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}

}
