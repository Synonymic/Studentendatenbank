<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<h1><s:text name="txt.welcome" /></h1>
<s:form>
	<s:submit key="btn.logout" action="Logout"/>
	<s:submit key="btn.addUser" action="NewUser"/>
</s:form>