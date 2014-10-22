package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for canceling the 'new-student-dialog'.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowSearchViewAction extends ActionSupport {
	
	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -6365094260849608334L;

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
