<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the company's attributes --%>
	<s:hidden name="company.id" />
	<s:textfield name="company.name" key="lbl.name" size="40"
		maxlength="100" requiredLabel="true" />
	<s:textfield name="company.addition" key="lbl.addition" size="40"
		maxlength="100"/>
	<s:textfield name="company.abbreviation" key="lbl.abbreviation"
		size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="company.address.street" key="lbl.streetName"
		requiredLabel="true" size="40" maxsize="51" />
	<s:textfield name="company.address.houseNumber" key="lbl.houseNumber"
		requiredLabel="true" size="5" maxsize="5" />
	<s:textfield name="company.address.postcode" key="lbl.cityCode"
		requiredLabel="true" size="5" maxsize="5" />
	<s:textfield name="company.address.city" key="lbl.cityName"
		requiredLabel="true" size="40" maxsize="85" />
	<s:textfield name="company.address.addition" key="lbl.addressAddition"
		 size="40" maxsize="80" />
	<s:textfield name="company.address.telephoneNumber"
		key="lbl.telephoneNumber" requiredLabel="true" size="15" maxsize="15" />
	<s:textfield name="company.address.fax" key="lbl.fax"
		 size="15" maxsize="15" />
	<s:textfield name="company.address.email" key="lbl.email"
		requiredLabel="true" size="40" maxsize="100" />
	<s:select name="inputContactId" key="lbl.contact" list="contactDisplayMap" />
	<s:select name="inputStudentId" key="lbl.student"
		list="studentDisplayMap" />
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveCompany" />
	<s:submit key="btn.cancel" action="ShowCompanyList" />
</s:form>