package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ExmatriculatedStudentDAO;
import de.nak.studentsdatabase.model.Student;

public class ExmatriculatedStudentServiceImpl implements
		ExmatriculatedStudentService {
	
	/** the exmatriculatedStudentDAO */
	private ExmatriculatedStudentDAO exmatriculatedStudentDAO;

	public ExmatriculatedStudentDAO getExmatriculatedStudentDAO() {
		return exmatriculatedStudentDAO;
	}

	public void setExmatriculatedStudentDAO(
			ExmatriculatedStudentDAO exmatriculatedStudentDAO) {
		this.exmatriculatedStudentDAO = exmatriculatedStudentDAO;
	}

	@Override
	public List<Student> loadAll() {
		return exmatriculatedStudentDAO.loadAll();
	}

}
