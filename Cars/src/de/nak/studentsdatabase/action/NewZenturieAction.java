package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.StudentService;

/**
 * Action for a single zenturie.
 *
 * @author Andreas Krey
 */
public class NewZenturieAction implements Action {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** the student service */
	private StudentService studentService;
	/** the studentDisplayMap hashMap */
	private HashMap<Long, String> studentDisplayMap = new HashMap<Long, String>();
	/** the studentList */
	private List<Student> studentList;
	/** The input studentId. */
	private Long InputStudentId;
	/**the examService. */
	private ExamService examService;
	/** the examDisplayMap hashMap */
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	/** the examList */
	private List<Exam> examList;
	/** The input examId. */
	private Long InputExamId;
	/**the manipelService. */
	private ManipelService manipelService;
	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();
	/** the manipelList */
	private List<Manipel> manipelList;
	/** The input studentId. */
	private Long InpuManipelId;

	@Override
	public String execute() {
		studentList = studentService.loadAll();
		examList = examService.loadAll();
		manipelList = manipelService.loadAll();

		for (Student student : studentList) {
			studentDisplayMap.put(student.getId(), student.getName()+" "+student.getFirstName());
		}
		for (Exam exam : examList) {
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		for (Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy());
		}
		return SUCCESS;

	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public HashMap<Long, String> getStudentDisplayMap() {
		return studentDisplayMap;
	}

	public void setStudentDisplayMap(HashMap<Long, String> studentDisplayMap) {
		this.studentDisplayMap = studentDisplayMap;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Long getInputStudentId() {
		return InputStudentId;
	}

	public void setInputStudentId(Long inputStudentId) {
		InputStudentId = inputStudentId;
	}

	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public HashMap<Long, String> getExamDisplayMap() {
		return examDisplayMap;
	}

	public void setExamDisplayMap(HashMap<Long, String> examDisplayMap) {
		this.examDisplayMap = examDisplayMap;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
	}

	public Long getInputExamId() {
		return InputExamId;
	}

	public void setInputExamId(Long inputExamId) {
		InputExamId = inputExamId;
	}

	public ManipelService getManipelService() {
		return manipelService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	public HashMap<Long, String> getManipelDisplayMap() {
		return manipelDisplayMap;
	}

	public void setManipelDisplayMap(HashMap<Long, String> manipelDisplayMap) {
		this.manipelDisplayMap = manipelDisplayMap;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public void setManipelList(List<Manipel> manipelList) {
		this.manipelList = manipelList;
	}

	public Long getInpuManipelId() {
		return InpuManipelId;
	}

	public void setInpuManipelId(Long inpuManipelId) {
		InpuManipelId = inpuManipelId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}