package de.nak.studentsdatabase.action;

import java.util.Calendar;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.service.ApplicantService;

/**
 * The action for saving an applicant to the database and displaying
 * an applicantList.
 * 
 * @author Dirk Johannßen
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
	
	@Override
	public void validate() {
		
		String dayOfBirthString;
		String monthOfBirthString;
		String yearOfBirthString;
		
		Integer dayOfBirthInt = null;
		Integer monthOfBirthInt = null;
		Integer yearOfBirthInt = null;
			
		String aplBthdStr = applicant.getDayOfBirth();
		
		try{
			if (aplBthdStr.contains(".")) {
				String[] parts = aplBthdStr.split("\\.");
				dayOfBirthString = parts[0];
				monthOfBirthString = parts[1];
				monthOfBirthString = String.valueOf(Integer.parseInt(monthOfBirthString));
				yearOfBirthString = parts[2];
				
				dayOfBirthInt = Integer.parseInt(dayOfBirthString);
				monthOfBirthInt = Integer.parseInt(monthOfBirthString);
				yearOfBirthInt = Integer.parseInt(yearOfBirthString);
				
			} else {
				addActionError(getText("msg.validator.birthDateNotValid"));
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			addActionError(getText("msg.validator.birthDateNotValid"));
			return;
		}catch(NullPointerException e){
			addActionError(getText("msg.validator.birthDateNotValid"));
			return;
		}catch(IllegalArgumentException e){
			addActionError(getText("msg.validator.birthDateNotValid"));
			return;
		}
		
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR);      // The current year as an int
		

		if(yearOfBirthInt > year) {
			addActionError(getText("msg.validator.yearInFuture"));
		}
		
		if(yearOfBirthInt < 1990){
			addActionError(getText("msg.validator.yearTooFarInPast"));
		}
		
		if(monthOfBirthInt.equals(8) && dayOfBirthInt > 28){
			addActionError(getText("msg.validator.monthTooFewDays"));
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

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}
