package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.CompanyService;
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

	private Long inputIdManipel;
	
	private Long inputIdZenturie;
	
	private Long inputIdCompany;
	
	private Long inputIdContact;
	
	private ManipelService manipelService;
	
	private ZenturieService zenturieService;
	
	private CompanyService companyService;
	
	/** the Student */
	private Student student;

	/** the studentId */
	private Long studentId;

	/** the studentList */
	private List<Student> studentList;

	/** the studentService */
	private StudentService studentService;

	/**
	 * Saves the student to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		student.setManipel(manipelService.load(inputIdManipel));
		student.setZenturie(zenturieService.load(inputIdZenturie));
		student.setCompany(companyService.load(inputIdCompany));
		studentService.save(student);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		studentList = studentService.loadAll();
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

	public Long getInputIdManipel() {
		return inputIdManipel;
	}

	public void setInputIdManipel(Long inputIdManipel) {
		this.inputIdManipel = inputIdManipel;
	}

	public Long getInputIdZenturie() {
		return inputIdZenturie;
	}

	public void setInputIdZenturie(Long inputIdZenturie) {
		this.inputIdZenturie = inputIdZenturie;
	}

	public Long getInputIdCompany() {
		return inputIdCompany;
	}

	public void setInputIdCompany(Long inputIdCompany) {
		this.inputIdCompany = inputIdCompany;
	}

	public Long getInputIdContact() {
		return inputIdContact;
	}

	public void setInputIdContact(Long inputIdContact) {
		this.inputIdContact = inputIdContact;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
