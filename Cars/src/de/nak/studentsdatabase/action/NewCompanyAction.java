package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for a single zenturie.
 *
 * @author Andreas Krey
 */
public class NewCompanyAction implements Action {
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
	/** the contactService. */
	private ContactService contactService;
	/** the contactDisplayMap hashMap */
	private HashMap<Long, String> contactDisplayMap = new HashMap<Long, String>();
	/** the contactList */
	private List<Contact> contactList;
	/** The input contactId. */
	private Long InputContactId;

	@Override
	public String execute() {
		studentList = studentService.loadAll();
		contactList = contactService.loadAll();

		for (Student student : studentList) {
			studentDisplayMap.put(student.getId(), student.getName() + " "
					+ student.getFirstName());
		}
		for (Contact contact : contactList) {
			contactDisplayMap.put(contact.getId(), contact.getName() + " "
					+ contact.getFirstName());
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

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public Long getInputContactId() {
		return InputContactId;
	}

	public void setInputContactId(Long inputContactId) {
		InputContactId = inputContactId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}