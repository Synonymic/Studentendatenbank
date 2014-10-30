package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for searching students through
 * a line of optional selections
 * 
 * @author Dirk Johannssen
 *
 */
public class SearchStudentAction implements Action {
	
	/** the studentService */
	private StudentService studentService;
	
	/** the studentList to be returned */
	private List<Student> studentList;
	
	/** the list that contains all students */
	private List<Student> allStudentsList;
	
	/** the gender */
	private String gender;
	
	/** the matriculationNumber */
	private String matriculationNumber;

	@Override
	public String execute() throws Exception {
		allStudentsList = studentService.loadAll();
		for(Student student : allStudentsList){
			
			if(student.getMatriculationNumber().equals(matriculationNumber)){
				studentList.add(student);
			}else if(student.getGender().equals(gender)){
				studentList.add(student);
			}
		}
		return SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public List<Student> getAllStudentsList() {
		return allStudentsList;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

}
