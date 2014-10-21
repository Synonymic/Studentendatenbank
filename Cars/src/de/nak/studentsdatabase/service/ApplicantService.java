package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Applicant;

/**
 * The Interface for the Applicant Service.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface ApplicantService {
	
	/**
	 * Saves a given Applicant.
	 * 
	 * @param applicant The Applicant.
	 */
	void save(Applicant applicant);
	
	/**
	 * Loads a single applicant.
	 * 
	 * @param id The identifier.
	 * @return an Applicant or null.
	 */
	Applicant load(Long id);
	
	/**
	 * Deletes a given Applicant from the database.	
	 * 
	 * @param applicant The Applicant to be deleted.
	 */
	void delete(Applicant applicant);
	
	/**
	 * Loads all applicants.
	 * 
	 * @return List<Applicant> which can be empty if there is no Applicant
	 */
	List<Applicant> loadAll();

}
