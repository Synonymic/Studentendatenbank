package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Exam;

/**
 * Exam Service Interface
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface ExamService {
	
	/**
	 *  Creates or updates an exam.
	 *  
	 * @param exam The Exam.
	 */
	void save(Exam exam);
	
	/**
	 * Loads a single exam.
	 * 
	 * @param id The Identifier.
	 * @return an exam or null.
	 */
	Exam load(Long id);
	
	/**
	 * Deletes the given exam.
	 * 
	 * @param exam The Exam.
	 */
	void delete(Exam exam);
	
	/**
	 * Loads all exams.
	 * 
	 * @return a list which is empty if no exam was found.
	 */
	List<Exam> loadAll();

}
