package de.nak.studentsdatabase.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

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
public class SaveStudentAction extends ActionSupport implements Action {

	public List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -4165196061954364976L;

	/** the Student */
	private Student student;

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

	@Override
	public String execute() throws Exception {
		manipelList = manipelService.loadAll();
		zenturieList = zenturieService.loadAll();
		companyList = companyService.loadAll();
		contactList = contactService.loadAll();
		examList = examService.loadAll();
		

		for(Zenturie zenturie : zenturieList){
			if(inputZenturieId.equals(zenturie.getId())){
				student.setZenturie(zenturie);
			}
		}
		
		
		// The zenturie needs to match the manipel, regardless of
		// the selected id. 
		for(Manipel manipel : manipelList){
			if(inputManipelId.equals(manipel.getId())){
				student.setManipel(manipel);
			}
		}
		
		for(Company company : companyList){
			if(inputCompanyId.equals(company.getId())){
				student.setCompany(company);
			}
		}
		
		for(Contact contact : contactList){
			if(inputContactId.equals(contact.getId())){
				student.setContact(contact);
			}
		}
		
		for(Company company : companyList){
			if(inputCompanyId.equals(company.getId())){
				student.setCompany(company);
			}
		}
		
		for(Exam exam : examList){
			if(inputExamId.equals(exam.getId())){
				student.setExam(exam.getName());
			}
		}
		
		// Check first if new company - then of course new contact as well.
		if(inputCompanyId.equals(-1)){
			
			companyStudents = new HashSet<Student>();
			contact = new Contact();
			company = new Company();
			companyAddress = new Address();
			
			contact.setCompany(company);
			contact.setFirstName("firstName");
			contact.setName("name");
			companyStudents.add(student);
			contact.setStudents(companyStudents);
			
			companyAddress.setAddition("Zusatz");
			companyAddress.setCity("aCity");
			companyAddress.setEmail("aMail");
			companyAddress.setHouseNumber("aHouseNumber");
			companyAddress.setFax("aFax");
			companyAddress.setPostcode("aPostCode");
			companyAddress.setStreet("aStreet");
			companyAddress.setTelephoneNumber("012345678");
			
			company.setAbbreviation("Abk");
			company.setAddition("Zusatz");
			company.setAddress(companyAddress);
			company.setName("aName");
			company.setStudents(companyStudents);
			
			studentService.save(student);
			return "newCompany";
		}
		
		if(inputContactId.equals(-1)){
			contact = new Contact();
			companyStudents = new HashSet<Student>();
			
			contact.setCompany(companyService.load(inputCompanyId));
			contact.setFirstName("firstName");
			contact.setName("name");
			companyStudents.add(student);
			contact.setStudents(companyStudents);
			
			studentService.save(student);
			return "newContact";
		}
		
		// if student is already enrolled, the other service needs
		// to be used to save the student
		// try catch, since a student can be new.
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

}
