package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;

/**
 * Action for showing the welcomeView.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowWelcomeViewAction implements Action{
	
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
