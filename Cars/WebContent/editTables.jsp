<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
	<%-- The manipel table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="" /></th>
			<th><s:text name="Course of Study" /></th>
			<th><s:text name="Vintage" /></th>
			<th><s:text name="Zenturies" /></th>
			<th><s:text name="Exams" /></th>
		</tr>
		<s:iterator value="manipelList">
			<tr>
				<td><s:hidden name="id" /></td>
				<td><s:textfield value="courseOfStudy" /></td>
				<td><s:textfield value="vintage" /></td>
				<td><s:textfield value="zenturies" /></td>
				<td><s:textfield value="exams" /></td>
			</tr>
		</s:iterator>
	</table>

	<%-- The zenturie table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="" /></th>
			<th><s:text name="Name" /></th>
			<th><s:text name="Manipel" /></th>
			<th><s:text name="Students" /></th>
			<th><s:text name="Exams" /></th>
		</tr>
		<s:iterator value="zenturieList">
			<tr>
				<td><s:hidden name="id" /></td>
				<td><s:textfield value="name" /></td>
				<td><s:textfield value="manipel" /></td>
				<td><s:textfield value="students" /></td>
				<td><s:textfield value="exams" /></td>
			</tr>
		</s:iterator>
	</table>

	<%-- The exam table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="" /></th>
			<th><s:text name="Name" /></th>
			<th><s:text name="Grade" /></th>
		</tr>
		<s:iterator value="examList">
			<tr>
				<td><s:hidden name="id" /></td>
				<td><s:textfield value="name" /></td>
				<td><s:textfield value="grade" /></td>
			</tr>
		</s:iterator>
	</table>

	<%-- The contact table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="" /></th>
			<th><s:text name="name" /></th>
			<th><s:text name="First Name" /></th>
			<th><s:text name="Company" /></th>
		</tr>
		<s:iterator value="contactList">
			<tr>
				<td><s:hidden name="id" /></td>
				<td><s:textfield value="name" /></td>
				<td><s:textfield value="firstName" /></td>
				<td><s:textfield value="company" /></td>
			</tr>
		</s:iterator>
	</table>

	<%-- The company table --%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>
			<th><s:text name="" /></th>
			<th><s:text name="Name" /></th>
			<th><s:text name="Addition" /></th>
			<th><s:text name="Abbrevitation" /></th>
			<th><s:text name="Contacts" /></th>
			<th><s:text name="Address" /></th>
			<th><s:text name="Students" /></th>
		</tr>
		<s:iterator value="companyList">
			<tr>
				<td><s:hidden name="id" /></td>
				<td><s:textfield value="name" /></td>
				<td><s:textfield value="addition" /></td>
				<td><s:textfield value="abbrevitation" /></td>
				<td><s:textfield value="contacts" /></td>
				<td><s:textfield value="address" /></td>
				<td><s:textfield value="students" /></td>
			</tr>
		</s:iterator>
	</table>
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveTables" />
</s:form>