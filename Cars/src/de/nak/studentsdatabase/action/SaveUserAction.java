package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.User;
import de.nak.studentsdatabase.service.UserService;

/**
 * The action for saving an user to the database.
 * 
 * @author Andreas Krey
 *
 */
public class SaveUserAction extends ActionSupport implements Action {

	/**
	 * The serial UID
	 */
	private static final long serialVersionUID = -5858450837323948243L;

	/** the user */
	private User user;
	/** the userId */
	private Long userId;
	/** the userService */
	private UserService userService;
	/** the input of confirmed password*/
	private String confirmPassword;

	@Override
	public String execute() throws Exception {
		userService.save(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void validate(){
		if("".equals(user.getName())){
			addFieldError("username", "Please insert an user name!");
		}
		if("".equals(user.getPassword())){
			addFieldError("password", "Please insert a password!");
		}
		if("".equals(getConfirmPassword())){
			addFieldError("confirmPassword", "Please confirm your password!");
		}
 
		if(!(user.getPassword().equals(getConfirmPassword()))){
			addFieldError("confirmPassword","The inserted password didn't match!");
		}
	}

}
