package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Student;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Student data access object.
 *
 * @author Andreas Krey
 */
public class StudentDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the student into the database.
	 *
	 * @param student The student to persist. The given entity can be transient or detached.
	 */
	public void save(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	/**
	 * Loads a single student entity from the database.
	 *
	 * @param id The identifier.
	 * @return a student or null if no student was found with the given identifier.
	 */
	public Student load(Long id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	/**
	 * Deletes the student from the database.
	 *
	 * @param student The student to be deleted.
	 */
	public void delete(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}

	/**
	 * Loads all students from the database.
	 *
	 * @return a list or student which is empty if no student was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from STUDENT").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
