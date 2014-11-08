package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import de.nak.studentsdatabase.model.Address;
import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.DiscontinuedStudent;
import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.ExmatriculatedStudent;
import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.DiscontinuedStudentService;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ExmatriculatedStudentService;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.StudentService;
import de.nak.studentsdatabase.service.ZenturieService;


/**
 * The action for saving a student to the database and displaying
 * a studentList.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class SaveStudentAction extends ActionSupport implements Action, Preparable{
	
	public List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -4165196061954364976L;

	/** the Student */
	private Student student;
	
	private Exam exam;
	
	private Zenturie zenturie;
	
	private Manipel manipel;

	/** the studentId */
	private Long studentId;
	
	/** the immatriculatedStudentService */
	private ImmatriculatedStudentService immatriculatedStudentService;

	/** the studentList */
	private List<Student> studentList;

	/** the studentService */
	private StudentService studentService;
	
	private ExmatriculatedStudentService exmatriculatedStudentService;
	
	private DiscontinuedStudentService discontinuedStudentService;
	
	private Company company;
	
	private Contact contact;
	
	private Set<Student> companyStudents;
	
	private Address companyAddress;
	
	/** the inputManipelId */
	private Long inputManipelId;
	
	/** the inputZenturieId */
	private Long inputZenturieId;
	
	/** the inputCompanyId */
	private Long inputCompanyId;
	
	private Long inputExamId;
	
	private Long inputContactId;
	
	private List<Manipel> manipelList;
	
	private List<Zenturie> zenturieList;
	
	private List<Company> companyList;
	
	private List<Exam> examList;
	
	private List<Contact> contactList;
	
	private ManipelService manipelService;
	
	private ZenturieService zenturieService;
	
	private CompanyService companyService;
	
	private ExamService examService;
	
	private ContactService contactService;
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();
	
	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();

	/** the companyDisplayMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		manipelList = manipelService.loadAll();
		zenturieList = zenturieService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		examList = examService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Bitte w‰hlen...");
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		manipelDisplayMap.put((long) -1, "Bitte w‰hlen...");
		
		for(Company company : companyList) {
			companyDisplayMap.put(company.getId(), company.getName());
		}
		companyDisplayMap.put((long) -1, "Bitte w‰hlen...");
		companyDisplayMap.put((long) -2, "Neue Firma");
		
		for(Exam exam : examList){
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getCompany().getName() +
					": " + contact.getFirstName());
		}
		companyDisplayMap.put((long) -1, "Bitte w‰hlen...");
		companyDisplayMap.put((long) -2, "Neue Firma");
		
		// Check first if new company - then of course new contact as well.
		if(student.getCompany().getId().equals((long) -2)){
			
			companyStudents = new HashSet<Student>();
			contact = new Contact();
			company = new Company();
			companyAddress = new Address();
			Set<Contact> contacts = new HashSet<Contact>();
			
			contact.setCompany(null);
			contact.setFirstName("firstName");
			contact.setName("name");
			companyStudents.add(student);
			contact.setStudents(companyStudents);
			contactService.save(contact);
			contacts.add(contact);
			
			
			companyAddress.setAddition("Zusatz");
			companyAddress.setCity("aCity");
			companyAddress.setEmail("aMail");
			companyAddress.setHouseNumber("aHouseNumber");
			companyAddress.setFax("aFax");
			companyAddress.setPostcode("12345");
			companyAddress.setStreet("aStreet");
			companyAddress.setTelephoneNumber("012345678");
			
			company.setAbbreviation("Abk");
			company.setAddition("Zusatz");
			company.setAddress(companyAddress);
			company.setName("aName");
			company.setStudents(companyStudents);
			
			company.setContacts(contacts);
			companyService.save(company);
			
			contact.setCompany(company);
			contactService.save(contact);
			
			student.setCompany(company);
			student.setContact(contact);
			
			studentService.save(student);
			return "newCompany";
		}
		
		if(student.getContact().getId().equals((long) -2)){
			contact = new Contact();
			companyStudents = new HashSet<Student>();
			
			contact.setCompany(companyService.load(inputCompanyId));
			contact.setFirstName("firstName");
			contact.setName("name");
			companyStudents.add(student);
			contact.setStudents(companyStudents);
			contactService.save(contact);
			student.setContact(contact);
			studentService.save(student);
			return "newContact";
		}
		

		zenturie = zenturieService.load(student.getZenturie().getId());
		student.setZenturie(zenturie);
		
		
		// if student is already enrolled, the other service needs
		// to be used to save the student
		//try catch, since a student can be new.
		try{
		if(studentService.load(student.getId()) instanceof ImmatriculatedStudent){
			immatriculatedStudentService.save(student);
		}else if(studentService.load(student.getId()) instanceof DiscontinuedStudent){
			discontinuedStudentService.save(student);
		}else if(studentService.load(student.getId()) instanceof ExmatriculatedStudent){
			exmatriculatedStudentService.save(student);
		}else{
			studentService.save(student);
		}
		}catch(IllegalArgumentException e){
			// Student has no id yet and is new
			studentService.save(student);
			studentService.immatriculate(student);
		}

		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// If the student is not set, the student ID has to be set.
		if (student.getCompany().getId().equals((long) -1)) {
			addActionError(getText("msg.selectCompany"));
		}
		
		if(student.getContact().getId().equals((long) -1)){
			addActionError(getText("msg.selectContact"));
		}
		
		if(student.getManipel().getId().equals((long) -1)){
			addActionError(getText("msg.selectManipel"));
		}
		
		if(student.getZenturie().getId().equals((long) -1)){
			addActionError(getText("msg.selectZenturie"));
		}
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

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public ManipelService getManipelService() {
		return manipelService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	public ZenturieService getZenturieService() {
		return zenturieService;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Long getInputManipelId() {
		return inputManipelId;
	}

	public void setInputManipelId(Long inputManipelId) {
		this.inputManipelId = inputManipelId;
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

	public List<Exam> getExamList() {
		return examList;
	}

	public Long getInputExamId() {
		return inputExamId;
	}

	public void setInputExamId(Long inputExamId) {
		this.inputExamId = inputExamId;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public Long getInputContactId() {
		return inputContactId;
	}

	public void setInputContactId(Long inputContactId) {
		this.inputContactId = inputContactId;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Set<Student> getCompanyStudents() {
		return companyStudents;
	}

	public void setCompanyStudents(Set<Student> companyStudents) {
		this.companyStudents = companyStudents;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}

	public void setExmatriculatedStudentService(
			ExmatriculatedStudentService exmatriculatedStudentService) {
		this.exmatriculatedStudentService = exmatriculatedStudentService;
	}

	public void setDiscontinuedStudentService(
			DiscontinuedStudentService discontinuedStudentService) {
		this.discontinuedStudentService = discontinuedStudentService;
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

	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}

	public void setCompanyDisplayMap(HashMap<Long, String> companyDisplayMap) {
		this.companyDisplayMap = companyDisplayMap;
	}

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public void setContactDisplayMap(HashMap<Long, String> contactDisplayMap) {
		this.contactDisplayMap = contactDisplayMap;
	}

	public HashMap<Long, String> getExamDisplayMap() {
		return examDisplayMap;
	}

	public void setExamDisplayMap(HashMap<Long, String> examDisplayMap) {
		this.examDisplayMap = examDisplayMap;
	}


	@Override
	public void prepare() throws Exception {
		manipelList = manipelService.loadAll();
		zenturieList = zenturieService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		examList = examService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Bitte w‰hlen...");
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		manipelDisplayMap.put((long) -1, "Bitte w‰hlen...");
		
		
		for(Company company : companyList) {
			companyDisplayMap.put(company.getId(), company.getName());
		}
		companyDisplayMap.put((long) -1, "Bitte w‰hlen...");
		companyDisplayMap.put((long) -2, "Neue Firma");
		
		for(Exam exam : examList){
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		
		
		for(Contact contact : contactList){
			contactDisplayMap.put(contact.getId(), contact.getCompany().getName() +
					": " + contact.getFirstName());
		}
		contactDisplayMap.put((long) -1, "Bitte w‰hlen...");
		contactDisplayMap.put((long) -2, "Neuer Betreuer"); 
	}


	public Exam getExam() {
		return exam;
	}


	public void setExam(Exam exam) {
		this.exam = exam;
	}


	public Zenturie getZenturie() {
		return zenturie;
	}


	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
	}


	public Manipel getManipel() {
		return manipel;
	}


	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

}
