<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2><s:text name="txt.discontinuedStudentsList" /></h2>
<s:form>
	<s:actionerror/>
	<%-- The student table --%>
	<table>
		<tr>
			<th></th>
			<th><s:text name="lbl.lastName" /> </th>
			<th><s:text name="lbl.firstName" /></th>
			<th><s:text name="lbl.dayOfBirth" /></th>
		</tr>
		<s:iterator value="discontinuedStudentList">
			<tr>
				<td><s:radio name="studentId" list="#{id:''}" theme="simple" /></td>
				<td><s:property value="name"/></td>
				<td><s:property value="firstName" />
				<td><s:property value="dayOfBirth"/></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.edit" action="EditStudent" />
	<s:submit key="btn.enroll" action="EnrollStudent" />
	<s:submit key="btn.manageStudents" action="ShowStudentList"/>
</s:form>