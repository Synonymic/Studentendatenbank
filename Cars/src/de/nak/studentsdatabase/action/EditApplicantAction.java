package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * Displays the selected applicant in the applicantForm.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class EditApplicantAction extends ActionSupport implements Action {
	
	/** The generated SerialUID. */
	private static final long serialVersionUID = 5743898982816887482L;

	/**The applicant service. */
	private ApplicantService applicantService;
	
	/** The applicant. */
	private Applicant applicant;
	
	/** The applicantId */
	private Long applicantId;
	

	/**
	 * Loads a given applicant for further edits.
	 */
	@Override
	public String execute() throws Exception {
		
		applicant = applicantService.load(applicantId);
		return SUCCESS;
	}
	
	/**
	 * validates wether or not id is set.
	 */
	@Override
	public void validate() {
		// If the applicant is not set, the applicant ID has to be set.
		if (applicant == null && applicantId == null) {
			addActionError(getText("msg.selectApplicant"));
		}
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
