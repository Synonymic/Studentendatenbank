<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the contact's attributes --%>
	<s:hidden name="contact.id" />
	<s:textfield name="contact.name" key="lbl.lastName" size="40"
		maxlength="100" requiredLabel="true" />
	<s:textfield name="contact.firstName" key="lbl.firstName" size="40"
		maxlength="100" requiredLabel="true" />
	<s:select name="inputStudentId" key="lbl.student"
		list="studentDisplayMap" />
	<s:select name="inputCompanyId" key="lbl.company" list="companyDisplayMap" />

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveContact" />
	<s:submit key="btn.cancel" action="ShowContactList" />
</s:form>