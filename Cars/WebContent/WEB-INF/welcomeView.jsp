<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>

<%-- The buttons --%>
<s:submit key="btn.manageApplicants" action="ShowApplicantListAction" />
<s:submit key="btn.manageStudents" action="ShowStudentListAction" />
<s:submit key="btn.createAttendanceList"  />
<s:submit key="btn.createResultsList"  />
<s:submit key="btn.manageTables" />
</s:form>