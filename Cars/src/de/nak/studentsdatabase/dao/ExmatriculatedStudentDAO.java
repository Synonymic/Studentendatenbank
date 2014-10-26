package de.nak.studentsdatabase.dao;

import org.hibernate.SessionFactory;

import de.nak.studentsdatabase.model.ExmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;

import java.util.List;

/**
 * Exmatriculated Student data access object.
 *
 * @author Andreas Krey
 */
public class ExmatriculatedStudentDAO extends StudentDAO{
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the exmatriculated student into the database.
	 *
	 * @param exmatriculatedStudent The student to persist. The given entity can be transient or detached.
	 */
	public void save(ExmatriculatedStudent exmatriculatedStudent) {
		sessionFactory.getCurrentSession().saveOrUpdate(exmatriculatedStudent);
	}

	/**
	 * Loads a single exmatriculated student entity from the database.
	 *
	 * @param id The identifier.
	 * @return an exmatriculated student or null if no exmatriculated student was found with the given identifier.
	 */
	public ExmatriculatedStudent load(Long id) {
		return (ExmatriculatedStudent) sessionFactory.getCurrentSession().get(ExmatriculatedStudent.class, id);
	}

	/**
	 * Loads all exmatriculated students from the database.
	 *
	 * @return a list or exmatriculated student which is empty if no exmatriculated student was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Exmatriculatedstudent").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
