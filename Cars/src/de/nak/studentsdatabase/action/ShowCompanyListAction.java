package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;

/**
 * The action to show a list of all companies.
 * 
 * @author Andreas Krey
 *
 */
public class ShowCompanyListAction implements Action {
	/** the contact list. */
	private List<Company> companyList;
	/** The company service */
	private CompanyService companyService;
	/** the contactList */
	private List<Contact> contactList;
	/** the contact service */
	private ContactService contactService;
	/** the contactDisplayMap hashMap */
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getName()+" "+contact.getFirstName());
		}
		return SUCCESS;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public void setContactDisplayMap(HashMap<Long, String> contactDisplayMap) {
		this.contactDisplayMap = contactDisplayMap;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	
}
