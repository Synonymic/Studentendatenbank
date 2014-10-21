package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.model.Company;

/**
 * The company service interface.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface CompanyService {
	
	/**
	 * Saves an given company.
	 * 
	 * @param company The company to be saved.
	 */
	void save(Company company);

	/**
	 * Loads a single company.
	 * 
	 * @param id The identifier for the company.
	 * @return company A single company.
	 */
	Company load(Long id);
	
	/**
	 * Deletes a given company.
	 * 
	 * @param company The company to be deleted.
	 */
	void delete(Company company);
	
	/**
	 * Loads all companies.
	 * 
	 * @return a list which is empty if no company could be found.
	 */
	List<Company> loadAll();
}
