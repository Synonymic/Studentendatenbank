package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Student;

/**
 * The discontinuedStudentService interface
 * 
 * @author Dirk Johannssen
 *
 */
public interface DiscontinuedStudentService {
	
	/** saves a given student. */
	void save(Student student);
	
	/** loads a student by a given id. */
	Student load(Long id);
	
	/** returns a list of all students or an empty list if no student was found. */
	List<Student> loadAll();
	
	

}
