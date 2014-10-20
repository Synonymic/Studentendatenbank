package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Exam;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Exam data access object.
 *
 * @author Andreas Krey
 */
public class ExamDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the exam into the database.
	 *
	 * @param exam The exam to persist. The given entity can be transient or detached.
	 */
	public void save(Exam exam) {
		sessionFactory.getCurrentSession().saveOrUpdate(exam);
	}

	/**
	 * Loads a single exam entity from the database.
	 *
	 * @param id The identifier.
	 * @return an exam or null if no exam was found with the given identifier.
	 */
	public Exam load(Long id) {
		return (Exam) sessionFactory.getCurrentSession().get(Exam.class, id);
	}

	/**
	 * Deletes the exam from the database.
	 *
	 * @param exam The exam to be deleted.
	 */
	public void delete(Exam exam) {
		sessionFactory.getCurrentSession().delete(exam);
	}

	/**
	 * Loads all exams from the database.
	 *
	 * @return a list or exam which is empty if no exam was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Exam> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from EXAM").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
