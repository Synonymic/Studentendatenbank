package de.nak.studentsdatabase.action;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * The action that provides the lists for company and caretaker
 * 
 * @author Dirk Johann�en
 *
 */
public class NewStudentAction implements Action {
	
	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the manipelService */
	private ManipelService manipelService; 
	
	/** the companyService */
	private CompanyService companyService;
	
	/** the examService */
	private ExamService examService;
	
	/** the contactService */
	private ContactService contactService;
	
	/** the inputContactId */
	private Long inputContactId;
	
	/** the inputExamId */
	private Long inputExamId;
	
	/** the inputZenturieId  */
	private Long inputZenturieId;
	
	/** the inputManipelId */
	private Long inputManipelId;
	
	/** the inputCompanyId */
	private Long InputCompanyId;

	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the zenturieList */
	private List<Zenturie> zenturieList;
	
	/** the comnpanyList */
	private List<Company> companyList;
	
	/** the examList. */
	private List<Exam> examList;
	
	/** the contactList. */
	private List<Contact> contactList;
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();

	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();

	/** the companyDisplayMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	
	/** the contactDisplayMap. */
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	
	/** the examDisplayMap. */
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	

	/**
	 * Generates all necessary displayMaps, loads all data.
	 */
	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		examList = examService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Bitte w�hlen...");
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		manipelDisplayMap.put((long) -1, "Bitte w�hlen...");
		
		
		for(Company company : companyList) {
			companyDisplayMap.put(company.getId(), company.getName());
		}
		companyDisplayMap.put((long) -2, "Neue Firma");
		companyDisplayMap.put((long) -1, "Bitte w�hlen...");
		
		for(Exam exam : examList){
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		
		 
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getCompany().getName() +
					": " + contact.getFirstName());
		}
		contactDisplayMap.put((long) -1, "Bitte w�hlen...");
		contactDisplayMap.put((long) -2, "Neuer Betreuer");
		
		
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

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Long getInputZenturieId() {
		return inputZenturieId;
	}

	public void setInputZenturieId(Long inputZenturieId) {
		this.inputZenturieId = inputZenturieId;
	}

	public Long getInputManipelId() {
		return inputManipelId;
	}

	public void setInputManipelId(Long inputManipelId) {
		this.inputManipelId = inputManipelId;
	}

	public Long getInputCompanyId() {
		return InputCompanyId;
	}

	public void setInputCompanyId(Long inputCompanyId) {
		InputCompanyId = inputCompanyId;
	}

	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}

	public void setCompanyDisplayMap(HashMap<Long, String> companyDisplayMap) {
		this.companyDisplayMap = companyDisplayMap;
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

	public Long getInputContactId() {
		return inputContactId;
	}

	public void setInputContactId(Long inputContactId) {
		this.inputContactId = inputContactId;
	}

	public Long getInputExamId() {
		return inputExamId;
	}

	public void setInputExamId(Long inputExamId) {
		this.inputExamId = inputExamId;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public HashMap<Long, String> getExamDisplayMap() {
		return examDisplayMap;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}