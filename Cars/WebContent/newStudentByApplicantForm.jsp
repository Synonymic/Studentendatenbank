<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:head key="lbl.doesApplicantExist" name="doesApplicantExist" />

<s:textfield key="lbl.lastName" name="applicant.name" />
<s:label key="lbl.dayOfBirth" />
<s:date name="applicant.dayOfBirth" />

<%-- At "yes" there needs to be taken a different action! --%>
<s:submit key="btn.no" name="" action="EditStudentAction" />
<s:submit key="btn.yes" name="" action="EditStudentAction" />