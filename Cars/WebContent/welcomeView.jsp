<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h2><s:text name="txt.welcomeView" /></h2>
<p><s:text name="txt.pleaseChoseAction" /></p>
<s:form>
	<s:actionerror/>
	
	
	<%-- The buttons --%>
	<s:submit key="btn.manageApplicants" action="ShowApplicantList"/>
	<s:submit key="btn.manageStudents" action="ShowStudentList"/>
	<s:submit key="btn.manageTables" action="ShowTablesList"/>
</s:form>
<s:form>
	<s:select name="inputId" key="lbl.zenturie" list="zenturieDisplayMap" />
	<s:submit action="GenerateAttendanceList" key="btn.generateAttendanceList" />
</s:form>
<s:form>
	<s:select name="inputId" key="lbl.manipel" list="manipelDisplayMap" />
	<s:submit action="GenerateResultsList" key="btn.generateResultsList" />
</s:form>
