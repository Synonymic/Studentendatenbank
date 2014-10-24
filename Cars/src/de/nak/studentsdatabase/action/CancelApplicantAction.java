package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;

/**
 * Is required to avoid stack traces in log. 
 * 
 * @author Dirk Johannﬂen
 *
 */
public class CancelApplicantAction implements Action {

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
