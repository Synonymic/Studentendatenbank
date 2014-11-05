package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;

/**
 * Service interface for immatriculatedStudents.
 * 
 * @author Dirk Johannssen
 *
 */
public interface ImmatriculatedStudentService {
	
	/** Saves the given Student */
	void save(ImmatriculatedStudent immatriculatedStudent);
	
	/** loads a student by a given id */
	ImmatriculatedStudent load(Long id);
	
	/** returns list of students which is empty if no student was found */
	List<Student> loadAll();

	
}
