package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

//import de.nak.studentsdatabase.model.Address;
import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * The action for saving an applicant to the database and displaying
 * an applicantList.
 * 
 * @author Dirk Johannﬂen
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
	
	/** the addressId */
	private Long addressId;

	/** the studentService */
	private ApplicantService applicantService;

	@Override
	public String execute() throws Exception {
		applicantService.save(applicant);
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}
