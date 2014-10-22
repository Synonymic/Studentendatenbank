package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.StudentService;

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

	/**
	 * Saves the student to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
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

}
