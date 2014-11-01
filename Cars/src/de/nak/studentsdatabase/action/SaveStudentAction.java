package de.nak.studentsdatabase.action;

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

	/** the studentList */
	private List<Student> studentList;

	/** the studentService */
	private StudentService studentService;
	
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
//				student.setZenturie(zenturie);
			}
		}
		
		
		// The zenturie needs to match the manipel, regardless of
		// the selected id. 
		for(Manipel manipel : manipelList){
			if(inputManipelId.equals(manipel.getId())){
//				student.setManipel(manipel);
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
		
		studentService.save(student);
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

}
