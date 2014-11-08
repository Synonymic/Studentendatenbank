package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for a single company.
 *
 * @author Andreas Krey
 */
public class CompanyAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current company. */
	private Company company;
	/** The company's identifier selected by the user. */
	private Long companyId;
	/** The company service. */
	private CompanyService companyService;
	/** The company list. */
	private List<Contact> contactList;
	/** The company service. */
	private ContactService contactService;
	/** the companyDisplayMap hashMap */
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	/** The input companyId. */
	private Long InputContactId;
	/** The student list. */
	private List<Student> studentList;
	/** The student service. */
	private StudentService studentService;
	/** the studentDisplayMap hashMap */
	private HashMap<Long, String> studentDisplayMap = new HashMap<Long, String>();
	/** The input studentId. */
	private Long InputStudentId;

	/**
	 * Saves the company to the database.
	 *
	 * @return the result string.
	 */
	public String execute() {
		companyService.save(company);
		return SUCCESS;
	}

	/**
	 * Deletes the selected company from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		company = companyService.load(companyId);
		if (company != null) {
			companyService.delete(company);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected company in the company form.
	 *
	 * @return the result string.
	 */
	public String load() {
		company = companyService.load(companyId);
		contactList = contactService.loadAll();
		studentList = studentService.loadAll();

		for (Contact contact : contactList) {
			contactDisplayMap.put(contact.getId(), contact.getName() + " "
					+ contact.getFirstName());
		}
		for (Student student : studentList) {
			studentDisplayMap.put(student.getId(), student.getName()+" "+student.getName());
		}
		return SUCCESS;
	}

	/**
	 * Cancels the editing. This method is implemented in order to avoid
	 * problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the company is not set, the company ID has to be set.
		if (company == null && companyId == null) {
			addActionError(getText("msg.selectCompany")); // Ändern!
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public HashMap<Long, String> getContactDisplayMap() {
		return contactDisplayMap;
	}

	public void setContactDisplayMap(HashMap<Long, String> contactDisplayMap) {
		this.contactDisplayMap = contactDisplayMap;
	}

	public Long getInputContactId() {
		return InputContactId;
	}

	public void setInputContactId(Long inputContactId) {
		InputContactId = inputContactId;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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

	public Long getInputStudentId() {
		return InputStudentId;
	}

	public void setInputStudentId(Long inputStudentId) {
		InputStudentId = inputStudentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

}
