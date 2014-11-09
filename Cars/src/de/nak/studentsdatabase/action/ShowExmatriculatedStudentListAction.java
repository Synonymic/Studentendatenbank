package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ExmatriculatedStudentService;

/**
 * Action for displaying all exmatriculated Students.
 * 
 * @author Dirk Johannssen
 *
 */
public class ShowExmatriculatedStudentListAction implements Action {
	
	/** the exmatriculatedStudentList. */
	private List<Student> exmatrStudentList;
	
	/** the exmatriculatedStudentService. */
	private ExmatriculatedStudentService exmatriculatedStudentService;

	/**
	 * loads a list of all examtriculated students.
	 */
	@Override
	public String execute() throws Exception {
		exmatrStudentList = exmatriculatedStudentService.loadAll();
		return SUCCESS;
	}

	public List<Student> getExmatrStudentList() {
		return exmatrStudentList;
	}

	public void setExmatriculatedStudentService(
			ExmatriculatedStudentService exmatriculatedStudentService) {
		this.exmatriculatedStudentService = exmatriculatedStudentService;
	}

}
