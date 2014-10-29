package de.nak.studentsdatabase.action;

import java.util.HashMap;
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
	
	/** the zenturieDisplayMap hashMap */
	private HashMap<Long, String> zenturieDisplayMap = new HashMap<Long, String>();
	

	/** the manipelDisplayMap hashMap */
	private HashMap<Long, String> manipelDisplayMap = new HashMap<Long, String>();

	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		
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
	
	public HashMap<Long, String> getZenturieDisplayMap() {
		return zenturieDisplayMap;
	}

	public void setZenturieDisplayMap(HashMap<Long, String> zenturieDisplayMap) {
		this.zenturieDisplayMap = zenturieDisplayMap;
	}

	public HashMap<Long, String> getManipelDisplayMap() {
		return manipelDisplayMap;
	}

	public void setManipelDisplayMap(HashMap<Long, String> manipelDisplayMap) {
		this.manipelDisplayMap = manipelDisplayMap;
	}


}
