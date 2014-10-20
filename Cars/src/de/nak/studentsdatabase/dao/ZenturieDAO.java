package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Zenturie;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Zenturie data access object.
 *
 * @author Andreas Krey
 */
public class ZenturieDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the zenturie into the database..
	 *
	 * @param zenturie The zenturie to persist. The given entity can be transient or detached.
	 */
	public void save(Zenturie zenturie) {
		sessionFactory.getCurrentSession().saveOrUpdate(zenturie);
	}

	/**
	 * Loads a single zenturie entity from the database.
	 *
	 * @param id The identifier.
	 * @return a zenturie or null if no zenturie was found with the given identifier.
	 */
	public Zenturie load(Long id) {
		return (Zenturie) sessionFactory.getCurrentSession().get(Zenturie.class, id);
	}

	/**
	 * Deletes the zenturie from the database.
	 *
	 * @param zenturie The zenturie to be deleted.
	 */
	public void delete(Zenturie zenturie) {
		sessionFactory.getCurrentSession().delete(zenturie);
	}

	/**
	 * Loads all zenturie's from the database.
	 *
	 * @return a list or zenturie which is empty if no car was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Zenturie> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from ZENTURIE").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
