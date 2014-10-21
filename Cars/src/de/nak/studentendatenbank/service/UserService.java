package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.model.User;

/**
 * The user service interface class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public interface UserService {
	
	/**
	 * Saves or updates a given user.
	 * 
	 * @param user The User.
	 */
	void save(User user);
	
	/**
	 * Loads a single user.
	 * 
	 * @param id The Identifier.
	 * @return a user or null.
	 */
	User load(Long id);
	
	/**
	 * Deletes a given user.
	 * 
	 * @param user The User.
	 */
	void delete(User user);
	
	/**
	 * Loads a list of all user.
	 * 
	 * @return a list which is empty if no user was found.
	 */
	List<User> loadAll();

}
