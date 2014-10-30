<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the user's attributes --%>
	<s:hidden name="user.id" />
	<s:textfield name="user.name" key="lbl.userName" size="40" maxlength="100" requiredLabel="true" />
	<s:password name="user.password" key="lbl.password" size="40" maxlength="100" requiredLabel="true" />
	<s:password name="confirmPassword" key="lbl.confirmPassword" size="40" maxlength="100" requiredLabel="true" />	
		
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveUser" />
	<s:submit key="btn.cancel" action="CancelUser" />
</s:form>