package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

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
	
	private Long iputId;
	
	private ManipelService manipelService;
	
	private List<Manipel> manipelList;

	@Override
	public String execute() throws Exception {
		manipelList = manipelService.loadAll();
		return SUCCESS;
	}

	public Long getIputId() {
		return iputId;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

}
