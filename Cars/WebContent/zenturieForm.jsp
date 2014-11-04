<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the zenturie's attributes --%>
	<s:hidden name="zenturie.id" />
	<s:textfield name="zenturie.name" key="lbl.name" size="40"
		maxlength="100" requiredLabel="true" />
	<s:submit key="btn.save" action="SaveZenturie" />
	<s:submit key="btn.cancel" action="ShowZenturieList" />
</s:form>