package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * The action that shows all applicants.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowApplicantListAction implements Action {

	/** The applicant list */
	private List<Applicant>	applicantList;
	
	/** The applicant service */
	private ApplicantService applicantService;
	
	@Override
	public String execute() throws Exception {
		applicantList = applicantService.loadAll();
		return SUCCESS;
	}

	public List<Applicant> getApplicantList() {
		return applicantList;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
	
}
