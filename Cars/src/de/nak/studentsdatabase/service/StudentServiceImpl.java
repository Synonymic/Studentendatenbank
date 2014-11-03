package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.StudentDAO;
import de.nak.studentsdatabase.model.Student;

/**
 * The student service implementation class.
 * 
 * @author Dirk Johannﬂen
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
	public List<Student> loadAll() {
		return studentDAO.loadAll();
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void exmatriculate(Student student) {
		studentDAO.exmatriculate(student);
		
	}

	
	
	

}
