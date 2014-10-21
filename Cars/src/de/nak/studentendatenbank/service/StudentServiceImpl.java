package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.dao.StudentDAO;
import de.nak.studentsdatabase.model.Student;

/**
 * The student service implementation class.
 * 
 * @author Dirk Johannßen
 *
 */
public class StudentServiceImpl implements StudentService {

	/**
	 * The studentDAO.
	 */
	private StudentDAO studentDAO;
	
	@Override
	public void save(Student student) {
		studentDAO.save(student);

	}

	@Override
	public Student load(Long id) {
		return studentDAO.load(id);
	}

	@Override
	public void delete(Student student) {
		studentDAO.delete(student);
	}

	@Override
	public List<Student> loadAll() {
		return studentDAO.loadAll();
	}

}
