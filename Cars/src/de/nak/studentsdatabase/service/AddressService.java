package de.nak.studentsdatabase.service;

import java.util.List;


import de.nak.studentsdatabase.model.Address;

/**
 * Adress Service Interface.
 * 
 * @author Dirk Johannßen
 *
 */
public interface AddressService {
	
	/**
	 * Creates or updates an address.
	 * 
	 * @param address
	 */
	void save(Address address);
	
	/**
	 * Loads a single address.
	 * 
	 * @param id the identifier
	 * @return an address or null
	 */
	Address load(long id);
	
	/**
	 * Deletes the given address.
	 * 
	 * @param address
	 */
	void delete(Address address);
	
	/**
	 *  Loads a list of all addresses.
	 * 
	 * @return a List which is empty if there is no address.
	 */
	List<Address> loadAll();
	

}
