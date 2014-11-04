package de.nak.studentsdatabase.action;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;
import de.nak.studentsdatabase.model.ImmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * 
 * Action for enrolling discontinued and exmatriculated students.
 * 
 * @author Dirk Johannssen
 *
 */
public class EnrollStudentAction implements Action {
	
	/** The studentId. */
	private Long studentId;
	
	/** The studentService. */
	private StudentService studentService;
	
	/** The student. */
	private Student student;
	
	/** The immatriculatedStudentService. */
	private ImmatriculatedStudentService immatriculatedStudentService;
	
	/** The studentList. */
	private List<Student> studentList;

	@Override
	public String execute() throws Exception {
		student = studentService.load(studentId);
		studentService.save(student);
		
		if(false == (student instanceof Student) && false == (student instanceof ImmatriculatedStudent) ){
			try{
				studentService.immatriculate(student);
			}catch(DataIntegrityViolationException e){
				System.out.println(e);
			}
		}
		
		studentList = immatriculatedStudentService.loadAll();
		return SUCCESS;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}

}
