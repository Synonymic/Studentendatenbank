package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for showing the welcomeView.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowWelcomeViewAction implements Action {

	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the manipelService */
	private ManipelService manipelService;

	/** the zenturieList */
	private List<Zenturie> zenturieList;
	
	/** the manipelList */
	private List<Manipel> manipelList;

	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		return SUCCESS;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}


}
