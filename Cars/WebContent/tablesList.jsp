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
					<td></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddContact" />
		<s:submit key="btn.edit" action="EditContact" />
		<s:submit key="btn.delete" action="DeleteContact" />
	</s:form>

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
				<th><s:text name="Address" /></th>
				<th><s:text name="Students" /></th>
			</tr>
			<s:iterator value="companyList">
				<tr>
					<td><s:radio name="companyId" list="#{id:''}" theme="simple" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="addition" /></td>
					<td></td>
					<td><s:property value="address" /></td>
					<td></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddCompany" />
		<s:submit key="btn.edit" action="EditCompany" />
		<s:submit key="btn.delete" action="DeleteCompany" />
	</s:form>

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
	</s:form>

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
					<td></td>
					<td></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddManipel" />
		<s:submit key="btn.edit" action="EditManipel" />
		<s:submit key="btn.delete" action="DeleteManipel" />
	</s:form>

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
					<td></td>
				</tr>
			</s:iterator>
		</table>
		<%-- The buttons --%>
		<s:submit key="btn.add" action="AddZenturie" />
		<s:submit key="btn.edit" action="EditZenturie" />
		<s:submit key="btn.delete" action="DeleteZenturie" />
	</s:form>


</s:form>
