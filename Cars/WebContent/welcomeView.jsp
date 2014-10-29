<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	
	
	<%-- The buttons --%>
	<s:submit key="btn.manageApplicants" action="ShowApplicantList"/>
	<s:submit key="btn.manageStudents" action="ShowStudentList"/>
</s:form>
<s:form>
	<s:select name="inputId" key="lbl.zenturie" list="zenturieDisplayMap" />
	<s:submit action="GenerateAttendanceList" key="btn.generateAttendanceList" />
</s:form>
<s:form>
	<s:select name="manipel.id" key="lbl.manipel" list="manipelDisplayMap" />
	<s:submit key="btn.generateResultsList" />
</s:form>