package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Applicant;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Applicant data access object.
 *
 * @author Andreas Krey
 */
public class ApplicantDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the applicant into the database.
	 *
	 * @param applicant
	 *            The applicant to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Applicant applicant) {
		sessionFactory.getCurrentSession().saveOrUpdate(applicant);
	}

	/**
	 * Loads a single applicant entity from the database.
	 *
	 * @param id
	 *            The identifier.
	 * @return an applicant or null if no applicant was found with the given
	 *         identifier.
	 */
	public Applicant load(Long id) {
		return (Applicant) sessionFactory.getCurrentSession().get(
				Applicant.class, id);
	}

	/**
	 * Deletes the applicant from the database.
	 *
	 * @param applicant
	 *            The applicant to be deleted.
	 */
	public void delete(Applicant applicant) {
		sessionFactory.getCurrentSession().delete(applicant);
	}

	/**
	 * Loads all applicants from the database.
	 *
	 * @return a list or applicant which is empty if no applicant was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Applicant> loadAll() {

		return sessionFactory.getCurrentSession()
				.createQuery("from Applicant").list();

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
