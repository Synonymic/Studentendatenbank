package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.Company;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Company data access object.
 *
 * @author Andreas Krey
 */
public class CompanyDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the company into the database.
	 *
	 * @param company The company to persist. The given entity can be transient or detached.
	 */
	public void save(Company company) {
		sessionFactory.getCurrentSession().saveOrUpdate(company);
	}

	/**
	 * Loads a single company entity from the database.
	 *
	 * @param id The identifier.
	 * @return a company or null if no company was found with the given identifier.
	 */
	public Company load(Long id) {
		return (Company) sessionFactory.getCurrentSession().get(Company.class, id);
	}

	/**
	 * Deletes the company from the database.
	 *
	 * @param company The company to be deleted.
	 */
	public void delete(Company company) {
		sessionFactory.getCurrentSession().delete(company);
	}

	/**
	 * Loads all companies from the database.
	 *
	 * @return a list or company which is empty if no company was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Company> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from COMPANY").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
