package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for showing the 'new-user'-view.
 * 
 * @author Andreas Krey
 *
 */
public class NewUserAction extends ActionSupport implements Action {

	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -8483188396728265712L;

	/**
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
