package de.nak.studentsdatabase.dao;

import org.hibernate.SessionFactory;

import de.nak.studentsdatabase.model.DiscontinuedStudent;
import de.nak.studentsdatabase.model.Student;

import java.util.List;

/**
 * Discontinued Student data access object.
 *
 * @author Andreas Krey
 */
public class DiscontinuedStudentDAO extends StudentDAO{
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the discontinued student into the database.
	 *
	 * @param discontinuedStudent The student to persist. The given entity can be transient or detached.
	 */
	public void save(DiscontinuedStudent discontinuedStudent) {
		sessionFactory.getCurrentSession().saveOrUpdate(discontinuedStudent);
	}

	/**
	 * Loads a single discontinued student entity from the database.
	 *
	 * @param id The identifier.
	 * @return a discontinued student or null if no discontinued student was found with the given identifier.
	 */
	public DiscontinuedStudent load(Long id) {
		return (DiscontinuedStudent) sessionFactory.getCurrentSession().get(DiscontinuedStudent.class, id);
	}

	/**
	 * Loads all discontinued students from the database.
	 *
	 * @return a list or discontinued student which is empty if no discontinued student was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Discountedstudent").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
