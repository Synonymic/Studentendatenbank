package de.nak.studentsdatabase.action;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * The action that provides the lists for company and caretaker
 * 
 * @author Dirk Johannﬂen
 *
 */
public class NewStudentAction implements Action {
	


	
	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the manipelService */
	private ManipelService manipelService; 
	
	private CompanyService companyService;
	
	private ContactService contactService;
	

	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the zenturieList */
	private List<Zenturie> zenturieList;
	
	private List<Contact> contactList;
	
	private List<Company> companyList;
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();

	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}

		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getName());
		}
		
		
		return SUCCESS;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	public HashMap<Long, String> getZenturieDisplayMap() {
		return zenturieDisplayMap;
	}

	public void setZenturieDisplayMap(HashMap<Long, String> zenturieDisplayMap) {
		this.zenturieDisplayMap = zenturieDisplayMap;
	}

	public HashMap<Long, String> getManipelDisplayMap() {
		return manipelDisplayMap;
	}

	public void setManipelDisplayMap(HashMap<Long, String> manipelDisplayMap) {
		this.manipelDisplayMap = manipelDisplayMap;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public void setContactDisplayMap(HashMap<Long, String> contactDisplayMap) {
		this.contactDisplayMap = contactDisplayMap;
	}

	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}

	public void setCompanyDisplayMap(HashMap<Long, String> companyDisplayMap) {
		this.companyDisplayMap = companyDisplayMap;
	}

}