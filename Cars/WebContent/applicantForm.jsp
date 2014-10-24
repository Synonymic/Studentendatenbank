<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the applicant's attributes --%>
	<s:hidden name="applicant.id" />
	<s:textfield name="applicant.name" key="lbl.lastName" size="40"
		maxlength="100" requiredLabel="true" />
	<s:textfield name="applicant.forename" key="lbl.firstName"
		size="40" maxlength="100" requiredLable="true" />
	<s:select name="applicant.salutation" key="lbl.salutation"
		headerKey="-1" headerValue="..."
		list="#{'0':'Herr', '1':'Frau', '2':'Herr Dr.', '3':'Frau Dr.', '4':'Herr Dr. Prof.', '5':'Frau Dr. Prof.'}"
		value="0" />
	<s:label  key="lbl.dateOfBirth" />
	<s:date name="applicant.dateOfBirth" format="dd/mm/yyyy" />
	<s:textfield name="applicant.placeOfBirth" key="lbl.placeOfBirth" />
	<s:textarea name="applicant.address" key="lbl.address" />
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveApplicant" />
	<s:submit key="btn.cancel" action="CancelApplicant" />
</s:form>