package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Adress;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Adresse-DAO.
 *
 * @author Andreas Krey
 */
public class AdresseDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder f�hrt eine Adresse in die Datenbank.
	 *
	 * @param adresse Die Adresse, die persistiert wird. Die vorliegende Entit�t kann transient oder separat sein.
	 */
	public void save(Adress adresse) {
		sessionFactory.getCurrentSession().saveOrUpdate(adresse);
	}

	/**
	 * L�dt eine Adressenentit�t aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return eine Adresse oder null, wenn keine Adresse zu der id zugeordnet ist.
	 */
	public Adress load(Long id) {
		return (Adress) sessionFactory.getCurrentSession().get(Adress.class, id);
	}

	/**
	 * L�scht eine Adresse aus der Datenbank.
	 *
	 * @param adresse Die zu l�schende Adresse.
	 */
	public void delete(Adress adresse) {
		sessionFactory.getCurrentSession().delete(adresse);
	}

	/**
	 * L�dt alle Adressen aus der Datenbank.
	 *
	 * @return eine Liste oder eine Adresse, welcher leer ist, falls Adresse nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Adress> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from ADRESSE").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
