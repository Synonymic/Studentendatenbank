package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Contact;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Company data access object.
 *
 * @author Andreas Krey
 */
public class ContactDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the contact into the database.
	 *
	 * @param contact The company to persist. The given entity can be transient or detached.
	 */
	public void save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

	/**
	 * Loads a single contact entity from the database.
	 *
	 * @param id The identifier.
	 * @return a contact or null if no contact was found with the given identifier.
	 */
	public Contact load(Long id) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	/**
	 * Deletes the contact from the database.
	 *
	 * @param contact The contact to be deleted.
	 */
	public void delete(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);
	}

	/**
	 * Loads all contacts from the database.
	 *
	 * @return a list or contact which is empty if no contact was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
