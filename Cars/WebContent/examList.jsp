<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<s:form>
		<%-- The exam table --%>
		<h3>Exam Table</h3>
		<table style="border-collapse: collapse; border: #CCC;" border="1">
			<tr>
				<th><s:text name="" /></th>
				<th><s:text name="name" /></th>
				<th><s:text name="Grade" /></th>
			</tr>
			<s:iterator value="examList">
				<tr>
					<td><s:radio name="examId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="grade" /></td>
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
