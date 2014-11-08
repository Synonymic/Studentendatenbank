<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form>
	<%-- Form fields for the applicant's attributes --%>
	<s:actionerror/>
	<s:hidden name="student.id" />
	<s:textfield name="student.name" key="lbl.lastName" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="student.firstName" key="lbl.firstName" size="40" maxlength="100" requiredLabel="true" />
	<s:select name="student.salutation" key="lbl.salutation"
		list="{'Herr','Frau'}" />
	<s:textfield name="student.dayOfBirth" key="lbl.dayOfBirth" requiredLabel="true" size="10" maxsize="10"/>
	<s:radio key="lbl.gender" name="student.gender" requiredLabel="true" list="{'male','female'}" />
	<s:textfield name="student.placeOfBirth" key="lbl.placeOfBirth" requiredLabel="true" />
	<s:textfield name="student.matriculationNumber" requiredLabel="true" key="lbl.enrolmentNumber" />
	
	<s:select name="student.manipel.id" key="lbl.manipel" list="manipelDisplayMap" />
	<s:select name="student.zenturie.id" key="lbl.zenturie" list="zenturieDisplayMap" /> 
	<s:select name="student.company.id" key="lbl.company" list="companyDisplayMap" />
	<s:select name="student.contact.id" key="lbl.contact" list="contactDisplayMap" />
	
	<s:textfield name="student.address.street" key="lbl.streetName" requiredLabel="true" size="40" maxsize="51"/>
	<s:textfield name="student.address.houseNumber" key="lbl.houseNumber" requiredLabel="true" size="5" maxsize="5" />
	<s:textfield name="student.address.postcode" key="lbl.cityCode" requiredLabel="true" size="5" maxsize="5"/>
	<s:textfield name="student.address.city" key="lbl.cityName" requiredLabel="true" size="40" maxsize="85"/>
	<s:textfield name="student.address.addition" key="lbl.addressAddition" size="40" maxsize="80"/>
	<s:textfield name="student.address.telephoneNumber" key="lbl.telephoneNumber" requiredLabel="true" 
	size="15" maxsize="15"/>
	<s:textfield name="student.address.fax" key="lbl.fax" size="15" maxsize="15"/>
	<s:textfield name="student.address.email" key="lbl.email" requiredLabel="true" size="40" maxsize="100"/>
	
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveStudent" />
	<s:submit key="btn.cancel" action="ShowStudentList" />
</s:form>