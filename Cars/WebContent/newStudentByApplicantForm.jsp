<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:form>
	<s:label key="lbl.doesApplicantExist" />
	
	<s:textfield key="lbl.lastName" name="applicant.name" />
	<s:textfield name="applicant.dayOfBirth" key="lbl.dateOfBirth"/>
	
	<%-- At "yes" there needs to be taken a different action! --%>
	<s:submit key="btn.no"  action="NewStudent" />
	<s:submit key="btn.yes" action="NewStudentByApplicant" />
</s:form>