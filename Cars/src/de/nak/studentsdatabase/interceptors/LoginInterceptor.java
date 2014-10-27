package de.nak.studentsdatabase.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor for login.
 * 
 * @author Andreas Krey
 */
@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();

		String loginId = (String) session.get("loginId");

		if (loginId == null) {
			return Action.LOGIN;
		} else {
			return actionInvocation.invoke();
		}
	}
}
