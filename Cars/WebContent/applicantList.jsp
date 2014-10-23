<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	<%-- The applicant table --%>
	<table>
		<tr>
			<th><s:text name="lbl.lastName" /> </th>
			<th><s:text name="lbl.dayOfBirth" /></th>
		</tr>
		<s:iterator value="applicantList">
			<tr>
				<td><s:radio name="applicantId" list="#{id:''}" theme="simple" /></td>
				<td><s:property value="name"/></td>
				<td><s:property value="dayOfBirth"/></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.addApplicant" action="NewApplicant" />
	<s:submit key="btn.editApplicant" action="EditApplicant" />
	<s:submit key="btn.deleteApplicant" action="DeleteApplicant" />
</s:form>