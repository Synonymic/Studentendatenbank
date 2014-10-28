package de.nak.studentsdatabase.service;

import java.util.List;
import de.nak.studentsdatabase.model.Contact;

/**
 * The interface for the contactService.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface ContactService {

	/**
	 * Creates or updates a contact.
	 * 
	 * @param address
	 */
	void save(Contact contact);
	
	/**
	 * Loads a single contact.
	 * 
	 * @param id the identifier
	 * @return a contact or null
	 */
	Contact load(long id);
	
	/**
	 * Deletes the given contact.
	 * 
	 * @param address
	 */
	void delete(Contact contact);
	
	/**
	 *  Loads a list of all contacts.
	 * 
	 * @return a List which is empty if there is no contact.
	 */
	List<Contact> loadAll();
}
