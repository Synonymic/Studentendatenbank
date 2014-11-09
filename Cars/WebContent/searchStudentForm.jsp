<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2><s:text name="txt.searchStudent" /></h2>
<p><s:text name="txt.selectSearchParams" /></p>
<s:form>
	<s:actionerror/>
	
	<s:radio key="lbl.gender" name="gender" list="{'male','female'}" />
	<s:textfield name="matriculationNumber" key="lbl.enrolmentNumber" />
	<s:textfield name="studentName" key="lbl.firstName" />
	<s:textfield name="studentLastName" key="lbl.name" />
	<s:select name="inputIdZenturie" key="lbl.zenturie" list="zenturieDisplayMap" />
	<s:select name="inputIdManipel" key="lbl.manipel" list="manipelDisplayMap" />
	<s:select name="inputIdCompany" key="lbl.company" list="companyDisplayMap" />
	
	<s:submit key="btn.search" action="SearchStudent" />
	<s:submit key="btn.manageStudents" action="ShowStudentList"/>
</s:form>