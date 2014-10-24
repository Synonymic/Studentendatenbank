package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Manipel;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Manipel data access object.
 *
 * @author Andreas Krey
 */
public class ManipelDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the manipel into the database.
	 *
	 * @param manipel The manipel to persist. The given entity can be transient or detached.
	 */
	public void save(Manipel manipel) {
		sessionFactory.getCurrentSession().saveOrUpdate(manipel);
	}

	/**
	 * Loads a single manipel entity from the database.
	 *
	 * @param id The identifier.
	 * @return a manipel or null if no manipel was found with the given identifier.
	 */
	public Manipel load(Long id) {
		return (Manipel) sessionFactory.getCurrentSession().get(Manipel.class, id);
	}

	/**
	 * Deletes the manipel from the database.
	 *
	 * @param manipel The manipel to be deleted.
	 */
	public void delete(Manipel manipel) {
		sessionFactory.getCurrentSession().delete(manipel);
	}

	/**
	 * Loads all manipel's from the database.
	 *
	 * @return a list or manipel which is empty if no manipel was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Manipel> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from MANIPEL").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
