<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<s:form>
		<%-- The company table --%>
		<h3>Company Table</h3>
		<table style="border-collapse: collapse; border: #CCC;" border="1">
			<tr>
				<th><s:text name="" /></th>
				<th><s:text name="name" /></th>
				<th><s:text name="Addition" /></th>
				<th><s:text name="Abbreviation" /></th>
				<th><s:text name="Contacts" /></th>
			</tr>
			<s:iterator value="companyList">
				<tr>
					<td><s:radio name="companyId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="addition" /></td>
					<td><s:property value="abbreviation" /></td>
					<td><s:select name="inputId" list="contactDisplayMap" /></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddCompany" />
		<s:submit key="btn.edit" action="EditCompany" />
		<s:submit key="btn.delete" action="DeleteCompany" />
		<s:submit key="btn.cancel" action="ShowTablesList" />
	</s:form>


</s:form>
