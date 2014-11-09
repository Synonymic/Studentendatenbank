package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

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
public class DiscontinueStudentAction extends ActionSupport implements Action {
	
	/** he serialVersionUID. */
	private static final long serialVersionUID = 7513173034306985761L;

	/** the studentService */
	private StudentService studentService;
	
	/** The student. */
	private Student student;
	
	/** the studentId. */
	private Long studentId;
	
	/** the studentList. */
	private List<Student> studentList;
	
	/** the immatriculatedStudentService. */
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
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		// If the applicant is not set, the applicant ID has to be set.
		if (student == null && studentId == null) {
			addActionError(getText("msg.selectApplicant"));
		}
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
