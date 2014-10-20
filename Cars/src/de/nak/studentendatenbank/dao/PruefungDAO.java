package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Exam;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Prüfung-DAO.
 *
 * @author Andreas Krey
 */
public class PruefungDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder führt eine Prüfung in die Datenbank.
	 *
	 * @param pruefung Die Prüfung, die persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(Exam pruefung) {
		sessionFactory.getCurrentSession().saveOrUpdate(pruefung);
	}

	/**
	 * Lädt eine Prüfungsentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Prüfung oder null, wenn keine Prüfung zu der id zugeordnet ist.
	 */
	public Exam load(Long id) {
		return (Exam) sessionFactory.getCurrentSession().get(Exam.class, id);
	}

	/**
	 * Löscht eine Prüfung aus der Datenbank.
	 *
	 * @param pruefung Die zu löschende Prüfung.
	 */
	public void delete(Exam pruefung) {
		sessionFactory.getCurrentSession().delete(pruefung);
	}

	/**
	 * Lädt alle Prüfungen aus der Datenbank.
	 *
	 * @return eine Liste oder eine Prüfung, welcher leer ist, falls Prüfung nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Exam> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from PRUEFUNG").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
