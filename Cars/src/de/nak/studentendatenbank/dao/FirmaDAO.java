package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Company;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * DasFirmar-DAO.
 *
 * @author Andreas Krey
 */
public class FirmaDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder f�hrt eine Firma in die Datenbank.
	 *
	 * @param firma Die Firma, die persistiert wird. Die vorliegende Entit�t kann transient oder separat sein.
	 */
	public void save(Company firma) {
		sessionFactory.getCurrentSession().saveOrUpdate(firma);
	}

	/**
	 * L�dt eine Firmenentit�t aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Firma oder null, wenn keine Firma zu der id zugeordnet ist.
	 */
	public Company load(Long id) {
		return (Company) sessionFactory.getCurrentSession().get(Company.class, id);
	}

	/**
	 * L�scht eine Firma aus der Datenbank.
	 *
	 * @param firma Die zu l�schende Firma.
	 */
	public void delete(Company firma) {
		sessionFactory.getCurrentSession().delete(firma);
	}

	/**
	 * L�dt alle Firmen aus der Datenbank.
	 *
	 * @return eine Liste oder eine Firma, welche leer ist, falls Firma nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Company> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from FIRMA").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
