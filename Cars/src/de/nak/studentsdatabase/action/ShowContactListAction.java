package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;




import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;

/**
 * The action to show a list of all contacts.
 * 
 * @author Andreas Krey
 *
 */
public class ShowContactListAction implements Action {
	/** the company list. */
	private List<Company> companyList;
	/** The company service */
	private CompanyService companyService;
	/** the contactList */
	private List<Contact> contactList;
	/** the contact service */
	private ContactService contactService;
	/** the contactDisplayMap hashMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		contactList = contactService.loadAll();
		companyList = companyService.loadAll();
		
		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		return SUCCESS;
	}


	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}


	public List<Company> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}


	public CompanyService getCompanyService() {
		return companyService;
	}


	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}


	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}


	public void setCompanyDisplayMap(HashMap<Long, String> companyDisplayMap) {
		this.companyDisplayMap = companyDisplayMap;
	}




	
}
