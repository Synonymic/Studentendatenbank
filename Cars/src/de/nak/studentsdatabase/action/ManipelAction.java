package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ExamService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for a single manipel.
 *
 * @author Andreas Krey
 */
public class ManipelAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current manipel. */
	private Manipel manipel;
	/** The manipel's identifier selected by the user. */
	private Long manipelId;
	/** The manipel service. */
	private ManipelService manipelService;
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
	/** the zenturieList */
	private List<Zenturie> zenturieList;
	/** The input zenturieId. */
	private Long InputZenturieId;

	/**
	 * Saves the manipel to the database.
	 *
	 * @return the result string.
	 */
	public String execute() {
		manipelService.save(manipel);
		return SUCCESS;
	}

	/**
	 * Deletes the selected manipel from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		manipel = manipelService.load(manipelId);
		if (manipel != null) {
			manipelService.delete(manipel);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected manipel in the company form.
	 *
	 * @return the result string.
	 */
	public String load() {
		manipel = manipelService.load(manipelId);
		examList = examService.loadAll();
		zenturieList = zenturieService.loadAll();

		for (Zenturie zenturie : zenturieList) {
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName() + " "
					+ zenturie.getManipel().getCourseOfStudy() + " "
					+ zenturie.getManipel().getVintage());
		}
		for (Exam exam : examList) {
			examDisplayMap.put(exam.getId(), exam.getName());
		}

		return SUCCESS;
	}

	/**
	 * Cancels the editing. This method is implemented in order to avoid
	 * problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the manipel is not set, the manipel ID has to be set.
		if (manipel == null && manipelId == null) {
			addActionError(getText("msg.selectManipel")); // Ändern!
		}
	}

	public Manipel getManipel() {
		return manipel;
	}

	public void setManipel(Manipel manipel) {
		this.manipel = manipel;
	}

	public Long getManipelId() {
		return manipelId;
	}

	public void setManipelId(Long manipelId) {
		this.manipelId = manipelId;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
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

	public Long getInputZenturieId() {
		return InputZenturieId;
	}

	public void setInputZenturieId(Long inputZenturieId) {
		InputZenturieId = inputZenturieId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ManipelService getManipelService() {
		return manipelService;
	}

}
