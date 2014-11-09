<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	<%-- The student table --%>
	Manipel: <s:property value="manipelName"/>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="lbl.name" /></th>
			<th><s:text name="lbl.grade" /> </th>
		</tr>
		<s:iterator value="examSet">
			<tr>
				<td><s:property value="name"/></td>
				<td><s:property value="grade"/></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.back" action="ShowWelcomeView" />
</s:form>