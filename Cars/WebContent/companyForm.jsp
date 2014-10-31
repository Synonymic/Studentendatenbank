<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the company's attributes --%>
	<s:hidden name="company.id" />
	<s:textfield name="company.name" key="lbl.name" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="company.addition" key="lbl.addition" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="company.abbreviation" key="lbl.abbreviation" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="company.address" key="lbl.address" size="40" maxlength="100" requiredLabel="true" />
<%--    <s:select name="inputContactId" key="lbl.contact" list="contactDisplayMap" /> --%>
<%--    <s:select name="inputStudentId" key="lbl.student" list="studentDisplayMap" /> --%>
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveCompany" />
	<s:submit key="btn.cancel" action="ShowTablesList" />
</s:form>