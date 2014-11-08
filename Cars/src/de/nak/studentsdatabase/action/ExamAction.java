package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.service.ExamService;

/**
 * Action for a single exam.
 *
 * @author Andreas Krey
 */
public class ExamAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current exam. */
	private Exam exam;
	/** The exam's identifier selected by the user. */
	private Long examId;
	/** The exam service. */
	private ExamService examService;

	/**
	 * Saves the exam to the database.
	 *
	 * @return the result string.
	 */
	public String execute() {
		examService.save(exam);
		return SUCCESS;
	}

	/**
	 * Deletes the selected exam from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		exam = examService.load(examId);
		if (exam != null) {
			examService.delete(exam);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected exam in the exam form.
	 *
	 * @return the result string.
	 */
	public String load() {
		exam = examService.load(examId);
		return SUCCESS;
	}

	/**
	 * Cancels the editing.
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		// If the exam is not set, the exam ID has to be set.
		if (exam == null && examId == null) {
			addActionError(getText("msg.selectExam")); //Ändern!
		}
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
}