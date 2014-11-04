<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<s:form>
		<%-- The contact table --%>
		<h3>Contact Table</h3>
		<table style="border-collapse: collapse; border: #CCC;" border="1">
			<tr>
				<th><s:text name="" /></th>
				<th><s:text name="name" /></th>
				<th><s:text name="First Name" /></th>
				<th><s:text name="Company" /></th>
			</tr>
			<s:iterator value="contactList">
				<tr>
					<td><s:radio name="contactId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="firstName" /></td>
					<td><s:select name="inputId" list="companyDisplayMap" /></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddContact" />
		<s:submit key="btn.edit" action="EditContact" />
		<s:submit key="btn.delete" action="DeleteContact" />		
		<s:submit key="btn.cancel" action="ShowTablesList" />
	</s:form>

</s:form>
