package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.StudentService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for editing a student.
 * 
 * @author Dirk Johann�en
 *
 */
public class EditStudentAction extends ActionSupport implements Action{

	/** The serial UID. */
	private static final long serialVersionUID = -9124145633944553666L;
	
	/** the Student */
	private Student student;
	
	/** the studentId */
	private Long studentId;
	
	/** the studentService */
	private StudentService studentService;
	
	/** the zenturie. */
	private Zenturie zenturie;
	
	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the manipelService */
	private ManipelService manipelService; 
	
	/** the companyService. */
	private CompanyService companyService;
	
	/** the contactService. */
	private ContactService contactService;
	
	/** the examService. */
	private ExamService examService;
	
	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the zenturieList */
	private List<Zenturie> zenturieList;
	
	/** the contactList. */
	private List<Contact> contactList;
	
	/** the companyList. */
	private List<Company> companyList;
	
	/** the examList. */
	private List<Exam> examList;
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();

	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();
	
	/** the contactDisplayMap */
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	
	/** the companyDisplayMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	
	/** the examDisplayMap. */
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	
	/** the inputExamId. */
	private Long inputExamId;
	
	/** the inputZenturieId. */
	private Long inputZenturieId;
	
	/** the inputCompanyId. */
	private Long inputCompanyId;
	
	/** the inputContactId. */
	private Long inputContactId;
	
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
		examList = examService.loadAll();
		
		try{
		zenturie = student.getZenturie();
		}catch(NullPointerException e){
			
		}
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Bitte w�hlen...");
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		manipelDisplayMap.put((long) -1, "Bitte w�hlen...");
		
		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		companyDisplayMap.put((long) -1, "Bitte w�hlen...");
		companyDisplayMap.put((long) -2, "Neue Firma");
		
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getCompany().getName() +
					": " + contact.getFirstName());
		}
		contactDisplayMap.put((long) -1, "Bitte w�hlen...");
		contactDisplayMap.put((long) -2, "Neuer Betreuer"); 
		
		for(Exam exam : examList){
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		
		student = studentService.load(studentId);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// If the student is not set, the student ID has to be set.
		if (student == null && studentId == null) {
			addActionError(getText("msg.selectStudent"));
		}
	}
	

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public void setManipelList(List<Manipel> manipelList) {
		this.manipelList = manipelList;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public void setZenturieList(List<Zenturie> zenturieList) {
		this.zenturieList = zenturieList;
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

	public Long getInputExamId() {
		return inputExamId;
	}

	public void setInputExamId(Long inputExamId) {
		this.inputExamId = inputExamId;
	}

	public Long getInputZenturieId() {
		return inputZenturieId;
	}

	public void setInputZenturieId(Long inputZenturieId) {
		this.inputZenturieId = inputZenturieId;
	}

	public Long getInputCompanyId() {
		return inputCompanyId;
	}

	public void setInputCompanyId(Long inputCompanyId) {
		this.inputCompanyId = inputCompanyId;
	}

	public Long getInputContactId() {
		return inputContactId;
	}

	public void setInputContactId(Long inputContactId) {
		this.inputContactId = inputContactId;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public HashMap<Long, String> getExamDisplayMap() {
		return examDisplayMap;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public Zenturie getZenturie() {
		return zenturie;
	}

	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
	}	
}
