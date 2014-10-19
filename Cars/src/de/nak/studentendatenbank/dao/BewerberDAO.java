package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Bewerber;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Bewerber-DAO.
 *
 * @author Andreas Krey
 */
public class BewerberDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder f�hrt einen Bewerber in die Datenbank.
	 *
	 * @param bewerber Der Bewerber, der persistiert wird. Die vorliegende Entit�t kann transient oder separat sein.
	 */
	public void save(Bewerber bewerber) {
		sessionFactory.getCurrentSession().saveOrUpdate(bewerber);
	}

	/**
	 * L�dt eine Bewerberentit�t aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return einen Bewerber oder null, wenn kein Bewerber zu der id zugeordnet ist.
	 */
	public Bewerber load(Long id) {
		return (Bewerber) sessionFactory.getCurrentSession().get(Bewerber.class, id);
	}

	/**
	 * L�scht einen Bewerber aus der Datenbank.
	 *
	 * @param bewerber Der zu l�schende Bewerber.
	 */
	public void delete(Bewerber bewerber) {
		sessionFactory.getCurrentSession().delete(bewerber);
	}

	/**
	 * L�dt alle Bewerber aus der Datenbank.
	 *
	 * @return eine Liste oder einen Bewerber, welcher leer ist, falls Bewerber nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Bewerber> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from BEWERBER").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
