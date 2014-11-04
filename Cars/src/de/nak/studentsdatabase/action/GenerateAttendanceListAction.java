package de.nak.studentsdatabase.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;

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
	
	/** the student list. */
	private List<Student> studentList;
	
	/** the list that holds all students that belong to the zenturie */
	private List<Student> studentsOfZenturieList;

	@Override
	public String execute() throws Exception {
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

}
