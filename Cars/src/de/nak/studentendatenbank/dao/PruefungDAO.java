package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Pruefung;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Pr�fung-DAO.
 *
 * @author Andreas Krey
 */
public class PruefungDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder f�hrt eine Pr�fung in die Datenbank.
	 *
	 * @param pruefung Die Pr�fung, die persistiert wird. Die vorliegende Entit�t kann transient oder separat sein.
	 */
	public void save(Pruefung pruefung) {
		sessionFactory.getCurrentSession().saveOrUpdate(pruefung);
	}

	/**
	 * L�dt eine Pr�fungsentit�t aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Pr�fung oder null, wenn keine Pr�fung zu der id zugeordnet ist.
	 */
	public Pruefung load(Long id) {
		return (Pruefung) sessionFactory.getCurrentSession().get(Pruefung.class, id);
	}

	/**
	 * L�scht eine Pr�fung aus der Datenbank.
	 *
	 * @param pruefung Die zu l�schende Pr�fung.
	 */
	public void delete(Pruefung pruefung) {
		sessionFactory.getCurrentSession().delete(pruefung);
	}

	/**
	 * L�dt alle Pr�fungen aus der Datenbank.
	 *
	 * @return eine Liste oder eine Pr�fung, welcher leer ist, falls Pr�fung nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Pruefung> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from PRUEFUNG").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
