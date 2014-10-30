package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;

/**
 * Is required to avoid stack traces in log. 
 * 
 * @author Andreas Krey
 *
 */
public class CancelUserAction implements Action {

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
