package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for a single manipel.
 *
 * @author Andreas Krey
 */
public class NewManipelAction implements Action {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** the examService. */
	private ExamService examService;
	/** the examDisplayMap hashMap */
	private HashMap<Long, String> examDisplayMap = new HashMap<Long, String>();
	/** the studentList */
	private List<Exam> examList;
	/** The input studentId. */
	private Long InputExamId;
	/** the zenturieService. */
	private ZenturieService zenturieService;
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();
	/** the manipelList */
	private List<Zenturie> zenturieList;
	/** The input studentId. */
	private Long InpuZenturieId;

	@Override
	public String execute() {
		examList = examService.loadAll();
		zenturieList = zenturieService.loadAll();

		for (Exam exam : examList) {
			examDisplayMap.put(exam.getId(), exam.getName());
		}
		for (Zenturie zenturie : zenturieList) {
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Neue Zenturie");
		return SUCCESS;

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

	public ZenturieService getZenturieService() {
		return zenturieService;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public HashMap<Long, String> getZenturieDisplayMap() {
		return zenturieDisplayMap;
	}

	public void setZenturieDisplayMap(HashMap<Long, String> zenturieDisplayMap) {
		this.zenturieDisplayMap = zenturieDisplayMap;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public void setZenturieList(List<Zenturie> zenturieList) {
		this.zenturieList = zenturieList;
	}

	public Long getInpuZenturieId() {
		return InpuZenturieId;
	}

	public void setInpuZenturieId(Long inpuZenturieId) {
		InpuZenturieId = inpuZenturieId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}