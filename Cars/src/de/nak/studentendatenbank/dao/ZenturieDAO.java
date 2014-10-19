package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Zenturie;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Zenturie-DAO.
 *
 * @author Andreas Krey
 */
public class ZenturieDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder führt eine Zenturie in die Datenbank.
	 *
	 * @param zenturie Die Zenturie, die persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(Zenturie zenturie) {
		sessionFactory.getCurrentSession().saveOrUpdate(zenturie);
	}

	/**
	 * Lädt eine Zenturienentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Zenturie oder null, wenn keine Zenturie zu der id zugeordnet ist.
	 */
	public Zenturie load(Long id) {
		return (Zenturie) sessionFactory.getCurrentSession().get(Zenturie.class, id);
	}

	/**
	 * Löscht eine Zenturie aus der Datenbank.
	 *
	 * @param zenturie Die zu löschende Zenturie.
	 */
	public void delete(Zenturie zenturie) {
		sessionFactory.getCurrentSession().delete(zenturie);
	}

	/**
	 * Lädt alle Zenturien aus der Datenbank.
	 *
	 * @return eine Liste oder eine Zenturie, welcher leer ist, falls Zenturie nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Zenturie> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from ZENTURIE").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
