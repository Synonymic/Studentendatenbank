package de.nak.studentsdatabase.dao;



import org.hibernate.SessionFactory;

import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;

import java.util.List;

/**
 * Student data access object.
 *
 * @author Andreas Krey
 */
public class ImmatriculatedStudentDAO extends StudentDAO{
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the immatriculated student into the database.
	 *
	 * @param immatriculadeStudent The immatriculated student to persist. The given entity can be transient or detached.
	 */
	public void save(ImmatriculatedStudent student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	/**
	 * Loads a single immatriculated student entity from the database.
	 *
	 * @param id The identifier.
	 * @return an immatriculated student or null if no immatriculated student was found with the given identifier.
	 */
	public ImmatriculatedStudent load(Long id) {
		return (ImmatriculatedStudent) sessionFactory.getCurrentSession().get(ImmatriculatedStudent.class, id);
	}


	/**
	 * Loads all students from the database.
	 *
	 * @return a list or student which is empty if no student was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from IMMATRICULATEDSTUDENT").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
