package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.User;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das User-DAO.
 *
 * @author Andreas Krey
 */
public class UserDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder führt einen User in die Datenbank.
	 *
	 * @param user Der User, der persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	/**
	 * Lädt eine Userentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return einen User oder null, wenn kein User zu der id zugeordnet ist.
	 */
	public User load(Long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	/**
	 * Löscht einen User aus der Datenbank.
	 *
	 * @param user Der zu löschende User.
	 */
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	/**
	 * Lädt alle User aus der Datenbank.
	 *
	 * @return eine Liste oder einen User, welcher leer ist, falls User nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<User> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from USER").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
