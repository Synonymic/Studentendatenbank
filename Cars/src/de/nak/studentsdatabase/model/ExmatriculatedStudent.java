package de.nak.studentsdatabase.model;


import javax.persistence.*;


/**
 * Entity of an exmatriculated student.
 *
 * @author Andreas Krey
 */
@Entity
@PrimaryKeyJoinColumn(name="STUDENT_ID")
public class ExmatriculatedStudent extends Student {	

}
