<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the applicant's attributes --%>
	<s:hidden name="applicant.id" />
	<s:hidden name="applicant.address.id" />
	<s:textfield name="applicant.name" key="lbl.lastName" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="applicant.firstName" key="lbl.firstName" size="40" maxlength="100" requiredLabel="true" />
	<s:select name="applicant.salutation" key="lbl.salutation"
		list="{'Herr','Frau'}" />
	<s:textfield name="applicant.dayOfBirth" key="lbl.dayOfBirth" requiredLabel="true" size="10" maxsize="10"/>
	<s:radio key="lbl.gender" name="applicant.gender" requiredLabel="true" list="{'male','female'}" />
	<s:textfield name="applicant.placeOfBirth" key="lbl.placeOfBirth" requiredLabel="true" />
	<s:textfield name="applicant.address.street" key="lbl.streetName" requiredLabel="true" size="40" maxsize="51"/>
	<s:textfield name="applicant.address.houseNumber" key="lbl.houseNumber" requiredLabel="true" size="5" maxsize="5" />
	<s:textfield name="applicant.address.postcode" key="lbl.cityCode" requiredLabel="true" size="5" maxsize="5"/>
	<s:textfield name="applicant.address.city" key="lbl.cityName" requiredLabel="true" size="40" maxsize="85"/>
	<s:textfield name="applicant.address.addition" key="lbl.addressAddition" size="40" maxsize="80"/>
	<s:textfield name="applicant.address.telephoneNumber" key="lbl.telephoneNumber" requiredLabel="true" size="15" maxsize="15"/>
	<s:textfield name="applicant.address.fax" key="lbl.fax" size="15" maxsize="15"/>
	<s:textfield name="applicant.address.email" key="lbl.email" requiredLabel="true" size="40" maxsize="100"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveApplicant" />
	<s:submit key="btn.cancel" action="CancelApplicant" />
</s:form>