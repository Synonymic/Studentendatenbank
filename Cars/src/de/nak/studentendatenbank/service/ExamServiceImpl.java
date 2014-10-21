package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ExamDAO;
import de.nak.studentsdatabase.model.Exam;

/**
 * The exam service implementation class
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ExamServiceImpl implements ExamService {
	
	/**
	 * The examDAO.
	 */
	private ExamDAO examDAO;

	@Override
	public void save(Exam exam) {
		examDAO.save(exam);

	}

	@Override
	public Exam load(Long id) {
		return examDAO.load(id);
	}

	@Override
	public void delete(Exam exam) {
		examDAO.delete(exam);

	}

	@Override
	public List<Exam> loadAll() {
		return examDAO.loadAll();
	}

}
