package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.StudentService;

/**
 * 
 * The action to supply a student list for attendanceList generation
 * 
 * @author Dirk Johannﬂen
 *
 */
public class GenerateAttendanceListAction implements Action {
	
	/** the zenturie */
	private Zenturie zenturie;
	
	/** the studentService */
	private StudentService studentService;
	
	/** the studentList */
	private List<Student> studentList;
	
	/** the list that holds all students that belong to the zenturie */
	private List<Student> studentsOfZenturieList;

	@Override
	public String execute() throws Exception {
		studentList = studentService.loadAll();
		for(Student student : studentList){
			if(student.getZenturie().equals(zenturie)){
				studentsOfZenturieList.add(student);
			}
		}
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setZenturie(Zenturie zenturie) {
		this.zenturie = zenturie;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentsOfZenturieList() {
		return studentsOfZenturieList;
	}

}
