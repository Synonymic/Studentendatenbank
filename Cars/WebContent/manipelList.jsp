<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<s:form>
		<%-- The manipel table --%>
		<h3>Manipel Table</h3>
		<table style="border-collapse: collapse; border: #CCC;" border="1">
			<tr>
				<th><s:text name="" /></th>
				<th><s:text name="course of study" /></th>
				<th><s:text name="Vintage" /></th>
				<th><s:text name="Zenturies" /></th>
				<th><s:text name="Exams" /></th>
			</tr>
			<s:iterator value="manipelList">
				<tr>
					<td><s:radio name="manipelId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="courseOfStudy" /></td>
					<td><s:property value="vintage" /></td>
					<td><s:select name="inputId" list="zenturieDisplayMap" /></td>
					<td><s:select name="inputId" list="examDisplayMap" /></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddManipel" />
		<s:submit key="btn.edit" action="EditManipel" />
		<s:submit key="btn.delete" action="DeleteManipel" />
		<s:submit key="btn.cancel" action="ShowTablesList" />
	</s:form>

</s:form>
