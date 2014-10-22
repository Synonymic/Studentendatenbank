package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * The action for saving an applicant to the database and displaying
 * an applicantList.
 * 
 * @author Dirk Johann�en
 *
 */
public class SaveApplicantAction extends ActionSupport implements Action {

	/**
	 * The serial UID
	 */
	private static final long serialVersionUID = -5858450837323948243L;

	/** the Student */
	private Applicant applicant;

	/** the studentId */
	private Long applicantId;

	/** the studentList */
	private List<Applicant> applicantList;

	/** the studentService */
	private ApplicantService applicantService;

	/**
	 * Saves the student to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		applicantService.save(applicant);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		applicantList = applicantService.loadAll();
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

	public List<Applicant> getApplicantList() {
		return applicantList;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}

}