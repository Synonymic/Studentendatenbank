package de.nak.studentsdatabase.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * 
 * The action to supply a student list for attendanceList generation
 * 
 * @author Dirk Johannﬂen
 *
 */
public class GenerateAttendanceListAction implements Action {
	
	/** the inputId for a zenturie */
	private Long inputId;
	
	private ImmatriculatedStudentService immatriculatedStudentService;
	
	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the zenturieName */
	private String zenturieName;
	
	/** the student list. */
	private List<Student> studentList;
	
	/** the list that holds all students that belong to the zenturie */
	private List<Student> studentsOfZenturieList;

	/**
	 * Generates an attendance list.
	 */
	@Override
	public String execute() throws Exception {
		zenturieName = zenturieService.load(inputId).getName();
		studentList = immatriculatedStudentService.loadAll();
		studentsOfZenturieList = new ArrayList<Student>();
		
		for(Student student : studentList){
			try{
			if(inputId.equals(student.getZenturie().getId())){
				studentsOfZenturieList.add(student);
			}
			}catch(NullPointerException e){
				continue;
			}
		}
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public List<Student> getStudentsOfZenturieList() {
		return studentsOfZenturieList;
	}
	
	public void setInputId(Long inputId) {
		this.inputId = inputId;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public String getZenturieName() {
		return zenturieName;
	}

	public void setZenturieName(String zenturieName) {
		this.zenturieName = zenturieName;
	}

}
