package de.nak.studentsdatabase.action;


import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;

/**
 * Action for a single contact.
 *
 * @author Andreas Krey
 */
public class ContactAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current contact. */
	private Contact contact;
	/** The contact's identifier selected by the user. */
	private Long contactId;
	/** The contact service. */
	private ContactService contactService; 
	/** The company list. */
	private List<Company> companyList;
	/** The company service. */
	private CompanyService companyService;
	/** the companyDisplayMap hashMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	/**The input companyId. */
	private Long InputCompanyId;
	
	
	
	public String execute() {
		companyList = companyService.loadAll();
		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		
		return SUCCESS;
	}

	/**
	 * Saves the contact to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		contactService.save(contact);
		return SUCCESS;
	}

	/**
	 * Deletes the selected contact from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		contact = contactService.load(contactId);
		if (contact != null) {
			contactService.delete(contact);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected contact in the contact form.
	 *
	 * @return the result string.
	 */
	public String load() {
		contact = contactService.load(contactId);
		companyList = companyService.loadAll();
		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		return SUCCESS;
	}

	/**
	 * Cancels the editing. This method is implemented in order to avoid
	 * problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the contact is not set, the contact ID has to be set.
		if (contact == null && contactId == null) {
			addActionError(getText("msg.selectContact")); // Ändern!
		}
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public ContactService getContactService() {
		return contactService;
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

	public Long getInputCompanyId() {
		return InputCompanyId;
	}

	public void setInputCompanyId(Long inputCompanyId) {
		this.InputCompanyId = inputCompanyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
