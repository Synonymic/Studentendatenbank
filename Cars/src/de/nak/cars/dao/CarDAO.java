package de.nak.cars.dao;

import de.nak.studentendatenbank.model.Student;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Car data access object.
 *
 * @author Stephan Anft
 */
public class CarDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the car into the database.
	 *
	 * @param car The car to persist. The given entity can be transient or detached.
	 */
	public void save(Student car) {
		sessionFactory.getCurrentSession().saveOrUpdate(car);
	}

	/**
	 * Loads a single car entity from the database.
	 *
	 * @param id The identifier.
	 * @return a car or null if no car was found with the given identifier.
	 */
	public Student load(Long id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	/**
	 * Deletes the car from the database.
	 *
	 * @param car The car to be deleted.
	 */
	public void delete(Student car) {
		sessionFactory.getCurrentSession().delete(car);
	}

	/**
	 * Loads all cars from the database.
	 *
	 * @return a list or car which is empty if no car was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Car").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
