package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for showing the 'new-applicant'-view.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class NewApplicantAction extends ActionSupport implements Action {

	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -8483188396728265712L;

	/**
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 * A direct link to the "ShowCarList" action does work but results in multiple stack traces in the
	 * application's log.
	 *
	 * @return the result string.
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
