package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.AddressDAO;
import de.nak.studentsdatabase.model.Address;

/**
 * The Address Service implementation class.
 * 
 * @author Dirk Johannßen
 *
 */
public class AddressServiceImpl implements AddressService {

	/**
	 * The AddressDAO.
	 */
	private AddressDAO addressDAO;

	@Override
	public void save(Address address) {
		addressDAO.save(address);

	}

	@Override
	public Address load(long id) {
		return addressDAO.load(id);
	}

	@Override
	public void delete(Address address) {
		addressDAO.delete(address);
	}

	@Override
	public List<Address> loadAll() {
		return addressDAO.loadAll();
	}

}
