<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	<%-- The student table --%>
	<table>
		<tr>
			<th><s:text name="lbl.lastName" /> </th>
		</tr>
		<s:iterator value="studentsOfZenturieList">
			<tr>
				<td><s:property value="name"/></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.back" action="ShowWelcomeView" />
</s:form>