package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.model.Manipel;

/**
 * The manipel service interface class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface ManipelService {

	/**
	 * Saves or updates the given manipel
	 * 
	 * @param manipel The Manipel
	 */
	void save(Manipel manipel);
	
	/**
	 * Loads a single manipel.
	 * 
	 * @param id The Identifier.
	 * @return a manipel or null.
	 */
	Manipel load(Long id);
	
	/**
	 * Deletes the given manipel.
	 * 
	 * @param manipel The Manipel.
	 */
	void delete(Manipel manipel);
	
	/**
	 * Loads a list with all manipels.
	 * 
	 * @return a list which is empty if no manipel was found.
	 */
	List<Manipel> loadAll();
}
