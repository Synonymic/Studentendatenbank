<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<s:actionerror />
		<s:submit key="btn.back" action="ShowWelcomeView" />
	<s:form>
		<%-- The company table --%>
		<h3>Company Management</h3>

		<%-- The buttons --%>
		<s:submit key="btn.manage" action="ShowCompanyList" />
	</s:form>
	<s:form>
		<%-- The contact table --%>
		<h3>Contact Management</h3>

		<%-- The buttons --%>
		<s:submit key="btn.manage" action="ShowContactList" />
	</s:form>

	<s:form>
		<%-- The exam table --%>
		<h3>Exam Management</h3>

		<%-- The buttons --%>
		<s:submit key="btn.manage" action="ShowExamList" />
	</s:form>

	<s:form>
		<%-- The manipel table --%>
		<h3>Manipel Management</h3>

		<%-- The buttons --%>
		<s:submit key="btn.manage" action="ShowManipelList" />
	</s:form>

	<s:form>
		<%-- The zenturie table --%>
		<h3>Zenturie Management</h3>

		<%-- The buttons --%>
		<s:submit key="btn.manage" action="ShowZenturieList" />
	</s:form>
</s:form>
