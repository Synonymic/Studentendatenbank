package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ApplicantService;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.StudentService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for editing a student.
 * 
 * @author Dirk Johannßen
 *
 */
public class NewStudentByApplicantAction implements Action {
	/**The applicant service. */
	private ApplicantService applicantService;
	
	/** The applicant. */
	private Applicant applicant;
	
	/** The applicantId */
	private Long applicantId;
	
	/** the student */
	private Student student;
	
	/** the studentService */
	private StudentService studentService;
	
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
	

	/**
	 * Displays the selected student in the student-edit form.
	 *
	 * @return the result string.
	 */
	public String execute() {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
			student.setZenturie(zenturie);
		}
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
			student.setManipel(manipel);
		}

		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
			student.setCompany(company);
		}
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getName());
			student.setContact(contact);
		}
		
		applicant = applicantService.load(applicantId);
		
		// immatrikulieren
		student = new Student();
		student.setAddress(applicant.getAddress());
		student.setName(applicant.getName());
		student.setDayOfBirth(applicant.getDayOfBirth());
		student.setFirstName(applicant.getFirstName());
		student.setGender(applicant.getGender());
		student.setPlaceOfBirth(applicant.getPlaceOfBirth());
		student.setSalutation(applicant.getSalutation());
		
		// Student speichern, Bewerber löschen
		studentService.save(student);
		applicantService.delete(applicant);
		return SUCCESS;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public Student getStudent() {
		return student;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public HashMap<Long, String> getZenturieDisplayMap() {
		return zenturieDisplayMap;
	}

	public HashMap<Long, String> getManipelDisplayMap() {
		return manipelDisplayMap;
	}

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public void setApplicantService(ApplicantService applicantService) {
		this.applicantService = applicantService;
	}
}
