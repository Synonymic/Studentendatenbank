package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for editing a student.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class EditStudentAction extends ActionSupport{

	/** The serial UID. */
	private static final long serialVersionUID = -9124145633944553666L;
	
	/** the Student */
	private Student student;
	
	/** the studentId */
	private Long studentId;
	
	/** the studentService */
	private StudentService studentService;
	
	/**
	 * Displays the selected student in the student-edit form.
	 *
	 * @return the result string.
	 */
	public String load() {
		student = studentService.load(studentId);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// If the car is not set, the car ID has to be set.
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
	
	

	
}
