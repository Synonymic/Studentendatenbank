<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<s:form>
		<%-- The zenturie table --%>
		<h3>Zenturie Table</h3>
		<table style="border-collapse: collapse; border: #CCC;" border="1">
			<tr>
				<th><s:text name="" /></th>
				<th><s:text name="name" /></th>
				<th><s:text name="Manipel" /></th>
				<th><s:text name="Students" /></th>
				<th><s:text name="Exams" /></th>
			</tr>
			<s:iterator value="zenturieList">
				<tr>
					<td><s:radio name="zenturieId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="manipel" /></td>
					<td><s:property value="students" /></td>
					<td><s:select name="inputId" list="examDisplayMap" /></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddExam" />
		<s:submit key="btn.edit" action="EditExam" />
		<s:submit key="btn.delete" action="DeleteExam" />
		<s:submit key="btn.cancel" action="ShowTablesList" />
	</s:form>



</s:form>