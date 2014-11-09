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
	
	/** the studentName */
	private String studentName;
	
	/** the studentLastName */
	private String studentLastName;
	
	/** the inputIdZenturie */
	private Long inputIdZenturie;
	
	/** the inputIdManipel */
	private Long inputIdManipel;
	
	/** the inputIdCompany */
	private Long inputIdCompany;

	/**
	 * Searches students by the given (or not) inputs.
	 */
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
		
		if(studentName == "" || studentName == null){
			studentName = "none";
		}
		
		if(studentLastName == "" || studentLastName == null){
			studentLastName = "none";
		}
		
		allStudentsList = immatriculatedStudentService.loadAll();
		
		try{
		for(Student student : allStudentsList){
			
			if(student.getMatriculationNumber().equals(matriculationNumberInteger)){
				studentList.add(student);
			}else if(student.getGender().equals(gender)){
				studentList.add(student);
			}else if(student.getFirstName().equals(studentName)){
				studentList.add(student);
			}else if(student.getName().equals(studentLastName)){
				studentList.add(student);
			}else if(student.getManipel().getId().equals(inputIdManipel)){
				studentList.add(student);
			}else if(student.getCompany().getId().equals(inputIdCompany)){
				studentList.add(student);
			}else if(student.getZenturie().getId().equals(inputIdZenturie)){
				studentList.add(student);
			}
		}
		}catch(NullPointerException e){
			
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public void setInputIdZenturie(Long inputIdZenturie) {
		this.inputIdZenturie = inputIdZenturie;
	}

	public void setInputIdManipel(Long inputIdManipel) {
		this.inputIdManipel = inputIdManipel;
	}

	public Long getInputIdZenturie() {
		return inputIdZenturie;
	}

	public Long getInputIdManipel() {
		return inputIdManipel;
	}

	public Long getInputIdCompany() {
		return inputIdCompany;
	}

	public void setInputIdCompany(Long inputIdCompany) {
		this.inputIdCompany = inputIdCompany;
	}



}
