package de.nak.studentsdatabase.action;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Exam;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.service.ManipelService;

/**
 * 
 * The action class for generation a results list.
 * 
 * @author Dirk Johannssen
 *
 */
public class GenerateResultsListAction implements Action {
	
	/** the inputId */
	private Long inputId;
	
	/** the inputId */
	private ManipelService manipelService;
	
	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the examSet */
	private Set<Exam> examSet;
	

	@Override
	public String execute() throws Exception {
		manipelList = manipelService.loadAll();
		
		for(Manipel manipel : manipelList){
			if(inputId.equals(manipel.getId())){
				examSet = manipel.getExams();
			}
		}
		
		return SUCCESS;
	}


	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}


	public void setInputId(Long inputId) {
		this.inputId = inputId;
	}


	public Set<Exam> getExamSet() {
		return examSet;
	}


	public void setExamSet(Set<Exam> examSet) {
		this.examSet = examSet;
	}

}
