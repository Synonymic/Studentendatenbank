package de.nak.studentsdatabase.service;

import java.util.List;
import de.nak.studentsdatabase.model.Student;

/**
 * 
 * Service for exmatriculated students.
 * 
 * @author Dirk Johannssen
 *
 */
public interface ExmatriculatedStudentService {
	
	/** returns all exmatriculated Students* or empty List if empty */
	List<Student> loadAll();

}
