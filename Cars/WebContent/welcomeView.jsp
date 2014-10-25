<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
<s:actionerror/>
<%-- The buttons --%>
<s:submit key="btn.manageApplicants" action="ShowApplicantList"/>
<s:submit key="btn.manageStudents" action="ShowStudentList"/>
</s:form>