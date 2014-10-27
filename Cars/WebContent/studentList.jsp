<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	<%-- The student table --%>
	<table>
		<tr>
			<th><s:text name="lbl.lastName" /> </th>
			<th><s:text name="lbl.dayOfBirth" /></th>
			<th><s:text name="lbl.enrolmentNumbr" /></th>
		</tr>
		<s:iterator value="studentList">
			<tr>
				<td><s:radio name="studentId" list="#{id:''}" theme="simple" /></td>
				<td><s:property value="name"/></td>
				<td><s:property value="dayOfBirth"/></td>
				<td><s:property value="matriculationNumber" /> </td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.add" action="isNewStudentApplicant" />
	<s:submit key="btn.edit" action="EditStudent" />
	<s:submit key="btn.back" action="ShowWelcomeView" />
</s:form>