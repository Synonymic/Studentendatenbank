package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Address;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Address data access object.
 *
 * @author Andreas Krey
 */
public class AddressDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the address into the database.
	 *
	 * @param address The address to persist. The given entity can be transient or detached.
	 */
	public void save(Address address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}

	/**
	 * Loads a single address entity from the database.
	 *
	 * @param id The identifier.
	 * @return an address or null if no address was found with the given identifier.
	 */
	public Address load(Long id) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
	}

	/**
	 * Deletes the address from the database.
	 *
	 * @param address The address to be deleted.
	 */
	public void delete(Address address) {
		sessionFactory.getCurrentSession().delete(address);
	}

	/**
	 * Loads all adresse's from the database.
	 *
	 * @return a list or address which is empty if no address was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Address> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from ADDRESS").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
