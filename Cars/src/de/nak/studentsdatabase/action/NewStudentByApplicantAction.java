package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Address;
import de.nak.studentsdatabase.model.Applicant;
import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ApplicantService;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.StudentService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for editing a student.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class NewStudentByApplicantAction extends ActionSupport implements Action {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 4375901221887650130L;

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
	
	private ExamService examService;
	

	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the zenturieList */
	private List<Zenturie> zenturieList;
	
	private List<Contact> contactList;
	
	private List<Company> companyList;
	
	private List<Exam> examList;
	
	private Long inputManipelId;
	
	private Long inputExamId;
	
	private Long inputZenturieId;
	
	private Long inputCompanyId;
	
	private Long inputContactId;
	
	/** the addres */
	private Address address;
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();

	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	

	/**
	 * Displays the selected student in the student-edit form.
	 *
	 * @return the result string.
	 */
	public String execute() {
		student = new Student();
		
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		examList = examService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}

		companyDisplayMap.put((long) -1, "Neue Firma");
		for(Company company : companyList){
			companyDisplayMap.put(company.getId(), company.getName());
		}
		
		contactDisplayMap.put((long) -1, "Neuer Betreuer"); 
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getCompany().getName() +
					": " + contact.getFirstName());
		}
		
		for(Exam exam : examList){
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		
		applicant = applicantService.load(applicantId);
		
		// take over address without violating the id.
		address = new Address();
		address.setAddition(applicant.getAddress().getAddition());
		address.setCity(applicant.getAddress().getCity());
		address.setEmail(applicant.getAddress().getEmail());
		address.setFax(applicant.getAddress().getFax());
		address.setHouseNumber(applicant.getAddress().getHouseNumber());
		address.setPostcode(applicant.getAddress().getPostcode());
		address.setStreet(applicant.getAddress().getStreet());
		address.setTelephoneNumber(applicant.getAddress().getTelephoneNumber());
		
		student.setAddress(address);
		
		//take over student-data without violating the id.
		student.setName(applicant.getName());
		student.setDayOfBirth(applicant.getDayOfBirth());
		student.setFirstName(applicant.getFirstName());
		student.setGender(applicant.getGender());
		student.setPlaceOfBirth(applicant.getPlaceOfBirth());
		student.setSalutation(applicant.getSalutation());
		student.setMatriculationNumber(12345);
		
		// saves and enrolls student, as well as deletes applicant.
		studentService.save(student);
		studentService.immatriculate(student);
		
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// If the applicant is not set, the applicant ID has to be set.
		if (applicant == null && applicantId == null) {
			addActionError(getText("msg.selectApplicant"));
		}
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

	public Long getInputManipelId() {
		return inputManipelId;
	}

	public void setInputManipelId(Long inputManipelId) {
		this.inputManipelId = inputManipelId;
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

	public ExamService getExamService() {
		return examService;
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
}
