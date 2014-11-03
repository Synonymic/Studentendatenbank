package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Student;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.StudentService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * The action to show a list of all companies.
 * 
 * @author Andreas Krey
 *
 */
public class ShowZenturieListAction implements Action {
	/** the zenturie list. */
	private List<Zenturie> zenturieList;
	/** The zenturie service */
	private ZenturieService zenturieService;
	/** the examList */
	private List<Exam> examList;
	/** the exam service */
	private ExamService examService;
	/** the contactDisplayMap hashMap */
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	/** the studentList */
	private List<Student> studentList;
	/** the student service */
	private StudentService studentService;
	/** the studentDisplayMap hashMap */
	private HashMap<Long, String> studentDisplayMap = new HashMap<Long, String>();


	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		examList = examService.loadAll();
		studentList = studentService.loadAll();
		
		for (Exam exam : examList) {
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		for (Student student : studentList) {
			studentDisplayMap.put(student.getId(), student.getName()+ " "+student.getFirstName());
		}
		
		return SUCCESS;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public void setZenturieList(List<Zenturie> zenturieList) {
		this.zenturieList = zenturieList;
	}

	public ZenturieService getZenturieService() {
		return zenturieService;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public List<Exam> getExamList() {
		return examList;
	}

	public void setExamList(List<Exam> examList) {
		this.examList = examList;
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

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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
	

}
