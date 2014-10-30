<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<s:actionerror/>
	
	<s:radio key="lbl.gender" name="gender" list="{'male','female'}" />
	<s:textfield name="matriculationNumber" key="lbl.enrolmentNumber" />
	
	<s:submit key="btn.search" action="SearchStudent" />
</s:form>