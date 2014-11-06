<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the manipel's attributes --%>
	<s:hidden name="manipel.id" />
	<s:textfield name="manipel.courseOfStudy" key="lbl.courseOfStudy" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="manipel.vintage" key="lbl.vintage" size="40" maxlength="100" requiredLabel="true" />
	<s:select name="inputZenturieId" key="lbl.zenturie" list="zenturieDisplayMap" /> 
    <s:select name="inputExamId" key="lbl.exam" list="examDisplayMap" /> 
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveManipel" />
	<s:submit key="btn.cancel" action="ShowManipelList" />
</s:form>