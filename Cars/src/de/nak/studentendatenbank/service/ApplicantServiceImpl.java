package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ApplicantDAO;
import de.nak.studentsdatabase.model.Applicant;

/**
 * 
 * The applicant service implementation class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ApplicantServiceImpl implements ApplicantService {

	/**
	 * The applicantDAO.
	 */
	private ApplicantDAO applicantDAO;
	
	@Override
	public void save(Applicant applicant) {
		applicantDAO.save(applicant);
	}

	@Override
	public Applicant load(Long id) {
		return applicantDAO.load(id);
	}

	@Override
	public void delete(Applicant applicant) {
		applicantDAO.delete(applicant);

	}

	@Override
	public List<Applicant> loadAll() {
		return applicantDAO.loadAll();
	}

}
