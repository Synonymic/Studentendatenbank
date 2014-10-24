package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.User;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * User data access object.
 *
 * @author Andreas Krey
 */
public class UserDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the user into the database.
	 *
	 * @param user The user to persist. The given entity can be transient or detached.
	 */
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/**
	 * Loads a single user entity from the database.
	 *
	 * @param id The identifier.
	 * @return an user or null if no user was found with the given identifier.
	 */
	public User load(Long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	/**
	 * Deletes the user from the database.
	 *
	 * @param user The user to be deleted.
	 */
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	/**
	 * Loads all users from the database.
	 *
	 * @return a list or user which is empty if no user was found.
	 */
	@SuppressWarnings("unchecked")
	public List<User> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from USER").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
