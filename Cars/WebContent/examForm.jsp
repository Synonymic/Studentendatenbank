<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the exam's attributes --%>
	<s:hidden name="exam.id" />
	<s:textfield name="exam.name" key="lbl.name" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="exam.grade" key="lbl.grade" size="40" maxlength="100" requiredLabel="true" />
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveExam" />
	<s:submit key="btn.cancel" action="ShowExamList" />
</s:form>