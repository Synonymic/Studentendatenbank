package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.DiscontinuedStudent;
import de.nak.studentsdatabase.model.ExmatriculatedStudent;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ImmatriculatedStudentService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * 
 * Class for exmatriculating a student.
 * 
 * @author Dirk Johannssen
 *
 */
public class ExmatriculateStudentAction implements Action {
	
	private StudentService studentService;
	
	private Student student;
	
	private Long studentId;
	
	private List<Student> studentList;
	
	private ImmatriculatedStudentService immatriculatedStudentService;

	@Override
	public String execute() throws Exception {
		student = studentService.load(studentId);
		if(student != null && false == (student instanceof DiscontinuedStudent)
				&& false == (student instanceof ExmatriculatedStudent)){
			studentService.exmatriculate(student);
		}
		studentList = immatriculatedStudentService.loadAll();
		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setImmatriculatedStudentService(
			ImmatriculatedStudentService immatriculatedStudentService) {
		this.immatriculatedStudentService = immatriculatedStudentService;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getStudentId() {
		return studentId;
	}

}
