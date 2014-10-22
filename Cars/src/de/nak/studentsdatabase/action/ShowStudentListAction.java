package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.StudentService;

/**
 * The action to show a list of all students.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowStudentListAction implements Action {

	/** the student list. */
	private List<Student> studentList;

	/** The student service */
	private StudentService studentService;

	@Override
	public String execute() throws Exception {
		studentList = studentService.loadAll();
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
