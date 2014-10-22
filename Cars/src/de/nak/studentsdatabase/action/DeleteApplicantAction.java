package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * Action for deleting an applicant and showing the applicantList.
 * 
 * @author dij
 *
 */
public class DeleteApplicantAction extends ActionSupport implements Action {

	/**
	 * The serial UID
	 */
	private static final long serialVersionUID = -2914624160483684551L;
	
	/** the applicant */
	private Applicant applicant;
	
	/** the applicantId */
	private Long applicantId;
	
	/** the applicantService */
	private ApplicantService applicantService;
	
	/** the applicantList */
	private List<Applicant> applicantList;
	
	@Override
	public String execute() throws Exception {
		applicantList = applicantService.loadAll();
		return SUCCESS;
	}
	
	/**
	 * Deletes the selected car from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		applicant = applicantService.load(applicantId);
		if (applicant != null) {
			applicantService.delete(applicant);
		}
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

	public List<Applicant> getApplicantList() {
		return applicantList;
	}

}
