package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Student;

/**
 * The student service interface class.
 * 
 * @author Dirk Johann�en
 *
 */
public interface StudentService {
	
	/**
	 * Saves or updates a student
	 * 
	 * @param student The Student
	 */
	void save(Student student);
	
	/**
	 * Loads a single student.
	 * 
	 * @param id The Identifier.
	 * @return a student or null.
	 */
	Student load(Long id);
	
	/**
	 * Loads a list of all students.
	 * 
	 * @return a list which is empty if no student was found.
	 */
	List<Student> loadAll();
	
	/**
	 * Exmatriculates a given student.
	 * @param student
	 */
	void exmatriculate(Student student);
	
	/**
	 * Discontinues a given student.
	 * @param student
	 */
	void discontinue(Student student);
	
	/**
	 * Enrolls a given student.
	 * @param student
	 */
	void immatriculate(Student student);
	
	/**
	 * Deletes a given student.
	 * @param student
	 */
	void delete(Student student);

}
