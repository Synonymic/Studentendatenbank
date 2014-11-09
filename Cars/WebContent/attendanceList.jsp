<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2><s:text name="txt.attendanceList" /></h2>
<s:form>
	<s:actionerror/>
	Zenturie: <s:property value="zenturieName"/>
	<%-- The student table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th>Name\Tag</th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
			<th style="padding: 50px;"></th>
		</tr>
		<s:iterator value="studentsOfZenturieList">
			<tr>
				<td><s:property value="name"/></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.back" action="ShowWelcomeView" />
</s:form>