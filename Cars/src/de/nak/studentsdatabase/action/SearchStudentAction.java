package de.nak.studentsdatabase.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;

/**
 * Action for searching students through
 * a line of optional selections
 * 
 * @author Dirk Johannssen
 *
 */
public class SearchStudentAction implements Action {
	
	/** the studentList to be returned */
	private List<Student> studentList;
	
	/** the list that contains all students */
	private List<Student> allStudentsList;
	
	/** The immatriculatedStudentService */
	private ImmatriculatedStudentService immatriculatedStudentService;
	
	/** the gender */
	private String gender;
	
	/** the matriculationNumber */
	private String matriculationNumber;
	
	/** the matriculationNumberInteger */
	private Integer matriculationNumberInteger;

	@Override
	public String execute() throws Exception {
		studentList = new ArrayList<Student>();
		
		if(matriculationNumber != null || matriculationNumber != ""){
			try{
			matriculationNumberInteger = Integer.parseInt(matriculationNumber);
			}catch(NumberFormatException e){
				matriculationNumberInteger = 0;
			}
		}else{
			matriculationNumberInteger = 0;
		}
		
		if(gender == "" || gender == null){
			gender = "none";
		}
		
		allStudentsList = immatriculatedStudentService.loadAll();
//		allStudentsList = studentService.loadAll();
		for(Student student : allStudentsList){
			
			if(student.getMatriculationNumber().equals(matriculationNumberInteger)){
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

	public Integer getMatriculationNumberInteger() {
		return matriculationNumberInteger;
	}

	public void setMatriculationNumberInteger(Integer matriculationNumberInteger) {
		this.matriculationNumberInteger = matriculationNumberInteger;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}



}
