package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ContactDAO;
import de.nak.studentsdatabase.model.Contact;

public class ContactServiceImpl implements ContactService {
	
	/** the contactDAO */
	private ContactDAO contactDAO;

	@Override
	public void save(Contact contact) {
		contactDAO.save(contact);
	}

	@Override
	public Contact load(long id) {
		return contactDAO.load(id);
	} 

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	public void delete(Contact contact) {
		contactDAO.delete(contact);
	}

	@Override
	public List<Contact> loadAll() {
		return contactDAO.loadAll();
	}

}
