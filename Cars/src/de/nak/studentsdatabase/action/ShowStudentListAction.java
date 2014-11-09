package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;

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
	private ImmatriculatedStudentService immatriculatedStudentService;

	/**
	 * Loads a list of all enrolled students for further display.
	 */
	@Override
	public String execute() throws Exception {
		studentList = immatriculatedStudentService.loadAll();
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}
}
