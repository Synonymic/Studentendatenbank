<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the zenturie's attributes --%>
	<s:hidden name="zenturie.id" />
	<s:textfield name="zenturie.name" key="lbl.name" size="40"
		maxlength="100" requiredLabel="true" />
	<s:select name="inputManipelId" key="lbl.manipel" list="manipelDisplayMap" />
	<s:select name="inputExamId" key="lbl.exam" list="examDisplayMap" />
	<s:select name="inputStudentId" key="lbl.student" list="studentDisplayMap" />	
	
	<s:submit key="btn.save" action="SaveZenturie" />
	<s:submit key="btn.cancel" action="ShowZenturieList" />
</s:form>