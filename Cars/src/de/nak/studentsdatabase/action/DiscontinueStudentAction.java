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
 * Class for discontinueing a student.
 * 
 * @author Dirk Johannssen
 *
 */
public class DiscontinueStudentAction implements Action {
	
	private StudentService studentService;
	
	private Student student;
	
	private Long studentId;
	
	private List<Student> studentList;
	
	private ImmatriculatedStudentService immatriculatedStudentService;

	@Override
	public String execute() throws Exception {
		student = immatriculatedStudentService.load(studentId);
		if(student != null
			&& false == (student instanceof DiscontinuedStudent)
				&& false == (student instanceof ExmatriculatedStudent))
		{
		studentService.discontinue(student);
		}
		studentList = immatriculatedStudentService.loadAll();
		return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}
