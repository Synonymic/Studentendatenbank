package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Manipel;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Manipel-DAO.
 *
 * @author Andreas Krey
 */
public class ManipelDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder führt ein Manipel in die Datenbank.
	 *
	 * @param manipel Das Manipel, das persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(Manipel manipel) {
		sessionFactory.getCurrentSession().saveOrUpdate(manipel);
	}

	/**
	 * Lädt eine Manipelentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return ein Manipel oder null, wenn kein Manipel zu der id zugeordnet ist.
	 */
	public Manipel load(Long id) {
		return (Manipel) sessionFactory.getCurrentSession().get(Manipel.class, id);
	}

	/**
	 * Löscht ein Manipel aus der Datenbank.
	 *
	 * @param manipel Das zu löschende Manipel.
	 */
	public void delete(Manipel manipel) {
		sessionFactory.getCurrentSession().delete(manipel);
	}

	/**
	 * Lädt alle Manipel aus der Datenbank.
	 *
	 * @return eine Liste oder ein Manipel, welches leer ist, falls Manipel nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Manipel> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from MANIPEL").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
