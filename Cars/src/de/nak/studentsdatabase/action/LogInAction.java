package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action for login.
 * 
 * @author Andreas Krey
 *
 */

@SuppressWarnings("serial")
public class LogInAction extends ActionSupport {
	/** The name of a user. */
	private String userName;
	/** The password of a user. */
	private String password;

	public String execute() {
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void validate() {
		if (getUserName().length() == 0) {
			addFieldError("userName", "UserName.required");
		} else if (!getUserName().equals("Admin")) {
			addFieldError("userName", "Sorry, User is invalid!");
		}
		if (getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
	}
}