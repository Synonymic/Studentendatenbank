package de.nak.studentsdatabase.model;

import javax.persistence.*;


/**
 * Entity of an discontinued student.
 *
 * @author Andreas Krey
 */
@Entity
@PrimaryKeyJoinColumn(name="STUDENT_ID")
public class DiscontinuedStudent extends Student{
	
}
