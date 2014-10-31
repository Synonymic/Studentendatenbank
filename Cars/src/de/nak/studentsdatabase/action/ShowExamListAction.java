package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.service.ExamService;

/**
 * The action to show a list of all companies.
 * 
 * @author Andreas Krey
 *
 */
public class ShowExamListAction implements Action {
	/** the exam list. */
	private List<Exam> examList;
	/** The company service */
	private ExamService examService;

	@Override
	public String execute() throws Exception {
		examList = examService.loadAll();
		return SUCCESS;
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

	}
