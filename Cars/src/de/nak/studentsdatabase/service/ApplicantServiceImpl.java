package de.nak.studentsdatabase.service;

import java.util.ArrayList;
import java.util.List;

import de.nak.studentsdatabase.dao.ApplicantDAO;
import de.nak.studentsdatabase.dao.StudentDAO;
import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.model.Student;

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

	private StudentDAO studentDAO;

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

	public void setApplicantDAO(ApplicantDAO applicantDAO) {
		this.applicantDAO = applicantDAO;
	}

	@Override
	public List<Applicant> loadAllApplicants() {

		List<Applicant> applicantList = applicantDAO.loadAll();
		List<Student> studentList = studentDAO.loadAll();
		List<Applicant> oddApplicantList = new ArrayList<Applicant>();

		for (Applicant applicant : applicantList) {
			for (Student student : studentList) {
				if (applicant.getName().equals(student.getName())
						&& applicant.getFirstName().equals(
								student.getFirstName())
						&& applicant.getDayOfBirth().equals(
								student.getDayOfBirth())) {
					oddApplicantList.add(applicant);
				}
			
			}
			
		}
		applicantList.removeAll(oddApplicantList);
		return applicantList;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
