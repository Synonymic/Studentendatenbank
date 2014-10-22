package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Zenturie;

/**
 * The zenturie service interface class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface ZenturieService {
	
	/**
	 * Saves or updates a given zenturie.
	 * 
	 * @param zenturie The Zenturie.
	 */
	void save(Zenturie zenturie);
	
	/**
	 * Loads a single zenturie.
	 * 
	 * @param id The Identifier.
	 * @return a zenturie or null.
	 */
	Zenturie load(Long id);
	
	/**
	 * Deletes a given zenturie.
	 * 
	 * @param zenturie The Zenturie.
	 */
	void delete(Zenturie zenturie);
	
	/**
	 * Loads a list of all zenturies.
	 * 
	 * @return a list which is empty if no zenturie was found.
	 */
	List<Zenturie> loadAll();

}
