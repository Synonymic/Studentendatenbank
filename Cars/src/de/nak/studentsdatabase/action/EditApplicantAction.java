package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * Displays the selected applicant in the applicantForm.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class EditApplicantAction implements Action {
	
	/**The applicant service. */
	private ApplicantService applicantService;
	
	/** The applicant. */
	private Applicant applicant;
	
	/** The applicantId */
	private Long applicantId;

	@Override
	public String execute() throws Exception {
		applicant = applicantService.load(applicantId);
		return SUCCESS;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

}
