package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.DiscontinuedStudentDAO;
import de.nak.studentsdatabase.model.DiscontinuedStudent;
import de.nak.studentsdatabase.model.Student;

/**
 * DiscontinuedStudentService implementation class.
 * 
 * @author Dirk Johannssen
 *
 */
public class DiscontinuedStudentServiceImpl implements
		DiscontinuedStudentService {
	
	/** The discontinuedStudentDAO */
	private DiscontinuedStudentDAO discontinuedStudentDAO;

	@Override
	public void save(DiscontinuedStudent discontinuedStudent) {
		discontinuedStudentDAO.save(discontinuedStudent);

	}

	@Override
	public DiscontinuedStudent load(Long id) {
		return discontinuedStudentDAO.load(id);
	}

	@Override
	public List<Student> loadAll() {
		return discontinuedStudentDAO.loadAll();
	}

	public DiscontinuedStudentDAO getDiscontinuedStudentDAO() {
		return discontinuedStudentDAO;
	}

	public void setDiscontinuedStudentDAO(
			DiscontinuedStudentDAO discontinuedStudentDAO) {
		this.discontinuedStudentDAO = discontinuedStudentDAO;
	}

}
