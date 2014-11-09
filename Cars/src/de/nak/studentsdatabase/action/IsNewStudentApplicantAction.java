package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * The action that serves an applicant
 * 
 * @author Dirk Johannssen
 *
 */
public class IsNewStudentApplicantAction implements Action {
	/** The applicant list */
	private List<Applicant>	applicantList;
	
	/** The applicant service */
	private ApplicantService applicantService;
	
	/**
	 * Loads applicants for asking wether or not applicant data
	 * should be used for new student.
	 */
	@Override
	public String execute() throws Exception {
		applicantList = applicantService.loadAllApplicants();
		return SUCCESS;
	}

	public List<Applicant> getApplicantList() {
		return applicantList;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
}
