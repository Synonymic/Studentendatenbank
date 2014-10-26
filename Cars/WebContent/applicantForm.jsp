<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the applicant's attributes --%>
	<s:hidden name="applicant.id" />
	<s:hidden name="address.id" />
	<s:textfield name="applicant.name" key="lbl.lastName" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="applicant.forename" key="lbl.firstName" size="40" maxlength="100" requiredLabel="true" />
	<s:select name="applicant.salutation" key="lbl.salutation"
		headerKey="-1" headerValue="..."
		list="#{'0':'Herr', '1':'Frau', '2':'Herr Dr.', '3':'Frau Dr.', '4':'Herr Dr. Prof.', '5':'Frau Dr. Prof.'}"
		value="0" />
	<s:label  key="lbl.dateOfBirth" />
	<s:textfield name="applicant.dateOfBirth" key="lbl.dateOfBirth" requiredLabel="true" size="10" maxsize="10"/>
	<s:textfield name="applicant.placeOfBirth" key="lbl.placeOfBirth" requiredLabel="true" />
	<s:textfield name="address.street" key="lbl.streetName" requiredLabel="true" size="40" maxsize="51"/>
	<s:textfield name="address.houseNumber" key="lbl.houseNumber" requiredLabel="true" size="5" maxsize="5" />
	<s:textfield name="address.postcode" key="lbl.cityCode" requiredLabel="true" size="5" maxsize="5"/>
	<s:textfield name="address.city" key="lbl.cityName" requiredLabel="true" size="40" maxsize="85"/>
	<s:textfield name="address.addition" key="lbl.addressAddition" requiredLabel="true" size="40" maxsize="80"/>
	<s:textfield name="address.telephoneNumber" key="lbl.telephoneNumber" requiredLabel="true" size="15" maxsize="15"/>
	<s:textfield name="address.fax" key="lbl.fax" requiredLabel="true" size="15" maxsize="15"/>
	<s:textfield name="address.email" key="lbl.email" requiredLabel="true" size="40" maxsize="100"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveApplicant" />
	<s:submit key="btn.cancel" action="CancelApplicant" />
</s:form>