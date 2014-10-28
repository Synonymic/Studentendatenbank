package de.nak.studentsdatabase.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


/**
 * Action for login.
 * 
 * @author Andreas Krey
 *
 */

@SuppressWarnings("serial")
public class LogInAction extends ActionSupport implements SessionAware {
    private String userName;
    private Map<String, Object> session;
    
    /**
     * Method for log out.
     * @return
     */
    public String logOut() {
            session.remove("loginId");
            addActionMessage("You have been Successfully Logged Out");
            return SUCCESS;
    }

    /**
     * Method for log in.
     * @return
     */
    public String login() {
            if (userName.isEmpty()) {
                    addActionError("Please insert a user name!");
                    return LOGIN;
            } else {
                    session.put("loginId", userName);
                    return SUCCESS;
            }
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
}