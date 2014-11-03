package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ImmatriculatedStudentDAO;
import de.nak.studentsdatabase.model.Student;

/**
 * 
 * @author Dirk Johannssen
 *
 */
public class ImmatriculatedStudentServiceImpl implements
		ImmatriculatedStudentService {
	
	/**  The immatriculatedStudentDAO */
	private ImmatriculatedStudentDAO immatriculatedStudentDAO;

	@Override
	public void save(Student student) {
		immatriculatedStudentDAO.save(student);

	}

	@Override
	public Student load(Long id) {
		return immatriculatedStudentDAO.load(id);
	}

	@Override
	public List<Student> loadAll() {
		return immatriculatedStudentDAO.loadAll();
	}

	public ImmatriculatedStudentDAO getImmatriculatedStudentDAO() {
		return immatriculatedStudentDAO;
	}

	public void setImmatriculatedStudentDAO(
			ImmatriculatedStudentDAO immatriculatedStudentDAO) {
		this.immatriculatedStudentDAO = immatriculatedStudentDAO;
	}

}
