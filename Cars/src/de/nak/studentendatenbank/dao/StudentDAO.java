package de.nak.studentendatenbank.dao;

import de.nak.studentendatenbank.model.Student;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Das Studenten-DAO.
 *
 * @author Andreas Krey
 */
public class StudentDAO {
	/** Die Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persistiert oder führt einen Studenten in die Datenbank.
	 *
	 * @param student Der Student, der persistiert wird. Die vorliegende Entität kann transient oder separat sein.
	 */
	public void save(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	/**
	 * Lädt eine Studentenentität aus der Datenbank.
	 *
	 * @param id Die Identifikationsnummer.
	 * @return einen Studenten oder null, wenn kein Student zu der id zugeordnet ist.
	 */
	public Student load(Long id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	/**
	 * Löscht einen Studenten aus der Datenbank.
	 *
	 * @param student Der zu löschende Student.
	 */
	public void delete(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}

	/**
	 * Lädt alle Studenten aus der Datenbank.
	 *
	 * @return eine Liste oder ein Studenten, welcher leer ist, falls Student nicht gefunden wurde.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from STUDENT").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
