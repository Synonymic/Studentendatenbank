package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for a single zenturie.
 *
 * @author Andreas Krey
 */
public class NewContactAction implements Action {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** the student service */
	private StudentService studentService;
	/** the studentDisplayMap hashMap */
	private HashMap<Long, String> studentDisplayMap = new HashMap<Long, String>();
	/** the studentList */
	private List<Student> studentList;
	/** The input studentId. */
	private Long InputStudentId;
	/**the companyService. */
	private CompanyService companyService;
	/** the companyDisplayMap hashMap */
	private HashMap<Long, String> companyDisplayMap = new HashMap<Long, String>();
	/** the companyList */
	private List<Company> companyList;
	/** The input companyId. */
	private Long InputCompanyId;


	@Override
	public String execute() {
		studentList = studentService.loadAll();
		companyList = companyService.loadAll();

		for (Student student : studentList) {
			studentDisplayMap.put(student.getId(), student.getName()+" "+student.getFirstName());
		}
		for (Company company : companyList) {
			companyDisplayMap.put(company.getId(), company.getName());
		}

		return SUCCESS;

	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public HashMap<Long, String> getStudentDisplayMap() {
		return studentDisplayMap;
	}

	public void setStudentDisplayMap(HashMap<Long, String> studentDisplayMap) {
		this.studentDisplayMap = studentDisplayMap;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Long getInputStudentId() {
		return InputStudentId;
	}

	public void setInputStudentId(Long inputStudentId) {
		InputStudentId = inputStudentId;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public HashMap<Long, String> getCompanyDisplayMap() {
		return companyDisplayMap;
	}

	public void setCompanyDisplayMap(HashMap<Long, String> companyDisplayMap) {
		this.companyDisplayMap = companyDisplayMap;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Long getInputCompanyId() {
		return InputCompanyId;
	}

	public void setInputCompanyId(Long inputCompanyId) {
		InputCompanyId = inputCompanyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}