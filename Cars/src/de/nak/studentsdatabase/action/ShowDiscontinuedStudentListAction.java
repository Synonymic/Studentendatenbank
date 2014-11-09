package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.DiscontinuedStudentService;

/**
 * Action for showing the discontinuedStudentList
 * 
 * @author Dirk Johannssen
 *
 */
public class ShowDiscontinuedStudentListAction implements Action {
	
	/** the discontinuedStudentList */
	private List<Student> discontinuedStudentList;
	
	/** the discontinuedStudentService */
	private DiscontinuedStudentService discontinuedStudentService;

	/**
	 * Loads a list of all discontinued students.
	 */
	@Override
	public String execute() throws Exception {
		discontinuedStudentList = discontinuedStudentService.loadAll();
		return SUCCESS;
	}

	public List<Student> getDiscontinuedStudentList() {
		return discontinuedStudentList;
	}

	public void setDiscontinuedStudentService(
			DiscontinuedStudentService discontinuedStudentService) {
		this.discontinuedStudentService = discontinuedStudentService;
	}

}
