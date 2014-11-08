<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	<%-- The applicant table --%>
	<table>
		<tr>
			<th></th>
			<th><s:text name="lbl.lastName" /> </th>
			<th><s:text name="lbl.firstName" /></th>
			<th><s:text name="lbl.born" /></th>
		</tr>
		<s:iterator value="applicantList">
			<tr>
				<td><s:radio name="applicantId" list="#{id:''}" theme="simple" /></td>
				<td><s:property value="name"/></td>
				<td><s:property value="firstName" /></td>
				<td><s:property value="dayOfBirth"/></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.add" action="NewApplicant" />
	<s:submit key="btn.edit" action="EditApplicant" />
	<s:submit key="btn.EnrollApplicant" action="NewStudentByApplicant" />
	<s:submit key="btn.delete" action="DeleteApplicant" />
	<s:submit key="btn.back" action="ShowWelcomeView" />
</s:form>