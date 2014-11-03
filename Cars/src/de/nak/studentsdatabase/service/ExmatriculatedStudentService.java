package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.ExmatriculatedStudent;
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
	
	/** saves a given exmatriculateStudent */
	void save(ExmatriculatedStudent exmatriculatedStudent);
	
	/** loads an exmatriculatedStudent by a given id */
	ExmatriculatedStudent load(Long id);

}
