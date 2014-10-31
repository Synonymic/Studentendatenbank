package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.service.ContactService;

/**
 * The action to show a list of all tables.
 * 
 * @author Andreas Krey
 *
 */
public class ShowTablesListAction implements Action {

	/** the contact list. */
	private List<Contact> contactList;

	/** The contact service */
	private ContactService contactService;

	@Override
	public String execute() throws Exception {
		contactList = contactService.loadAll();
		return SUCCESS;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
