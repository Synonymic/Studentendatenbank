package de.nak.studentsdatabase.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.User;
import de.nak.studentsdatabase.service.UserService;

/**
 * Action for login.
 * 
 * @author Andreas Krey
 *
 */

@SuppressWarnings("serial")
public class LogInAction extends ActionSupport implements SessionAware, Action {
	/** User name value of input. */
	private String userName;
	/** Password value of input. */
	private String Password;
	/** List of users */
	private List<User> userList;
	/** The user service */
	private UserService userService;
	/** Map for session */
	private Map<String, Object> session;

	/**
	 * Method for log in.
	 * 
	 * @return
	 */
	public String login() throws Exception {
		userList = userService.loadAll();
		
		
		if (userName.isEmpty()) {
			addActionError("Please insert a user name!");
			return LOGIN;
		} else {
			session.put("loginId", userName);
			return SUCCESS;

		}
	}

	/**
	 * Method for log out.
	 * 
	 * @return
	 */
	public String logOut() {
		session.remove("loginId");
		addActionMessage("You have been Successfully Logged Out");
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}