package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;


import de.nak.studentsdatabase.model.Contact;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ContactService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * The action to show a list of all contacts.
 * 
 * @author Andreas Krey
 *
 */
public class ShowContactListAction implements Action {
	/** the student list. */
	private List<Student> studentList;
	/** The student service */
	private StudentService studentService;
	/** the contactList */
	private List<Contact> contactList;
	/** the contact service */
	private ContactService contactService;
	/** the contactDisplayMap hashMap */
	private HashMap<Long, String> studentDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		contactList = contactService.loadAll();
		studentList = studentService.loadAll();
		
		for(Student student : studentList){
			studentDisplayMap.put(student.getId(), student.getName()+" "+student.getFirstName());
		}
		return SUCCESS;
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


	
}
