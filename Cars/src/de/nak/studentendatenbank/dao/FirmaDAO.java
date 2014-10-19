package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Firma;

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
	 * Persistiert oder führt eine Firma in die Datenbank.
	 *
	 * @param firma Die Firma, die persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(Firma firma) {
		sessionFactory.getCurrentSession().saveOrUpdate(firma);
	}

	/**
	 * Lädt eine Firmenentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Firma oder null, wenn keine Firma zu der id zugeordnet ist.
	 */
	public Firma load(Long id) {
		return (Firma) sessionFactory.getCurrentSession().get(Firma.class, id);
	}

	/**
	 * Löscht eine Firma aus der Datenbank.
	 *
	 * @param firma Die zu löschende Firma.
	 */
	public void delete(Firma firma) {
		sessionFactory.getCurrentSession().delete(firma);
	}

	/**
	 * Lädt alle Firmen aus der Datenbank.
	 *
	 * @return eine Liste oder eine Firma, welche leer ist, falls Firma nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Firma> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from FIRMA").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
