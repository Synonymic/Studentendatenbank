package de.nak.studentsdatabase.dao;

import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;

//import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Student data access object.
 *
 * @author Andreas Krey
 */
public class StudentDAO {
	/** The Hibernate Session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the student into the database.
	 *
	 * @param student The student to persist. The given entity can be transient or detached.
	 */
	public void save(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	/**
	 * Loads a single student entity from the database.
	 *
	 * @param id The identifier.
	 * @return a student or null if no student was found with the given identifier.
	 */
	public Student load(Long id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	/**
	 * Inserts the student into table EXMATRICULATEDSTUDENT.
	 *
	 * @param student The student to be exmatriculated.
	 */
	public void exmatriculate(ImmatriculatedStudent student) {
//		 String hql = "delete from Student where id = :id";
//	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//	        query.setLong("id",student.getId());
//	        query.executeUpdate();
		sessionFactory.getCurrentSession().saveOrUpdate( student);
	}
	
	/**
	 * Inserts the student into table DISCONTINUEDSTUDENT.
	 *
	 * @param student The student to be discontinued.
	 */
	public void discontinue(ImmatriculatedStudent student) {
		sessionFactory.getCurrentSession().saveOrUpdate( student);
	}
	
	/**
	 * Inserts the student into table IMMATRICULATEDSTUDENT.
	 *
	 * @param student The student to be immatriculated.
	 */
	public void immatriculate(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate( student);
	}

	/**
	 * Loads all students from the database.
	 *
	 * @return a list or student which is empty if no student was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
