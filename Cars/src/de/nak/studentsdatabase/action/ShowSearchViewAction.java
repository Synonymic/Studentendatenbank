package de.nak.studentsdatabase.action;

import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * Action for canceling the 'new-student-dialog'.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ShowSearchViewAction extends ActionSupport {
	
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
	
	/** the inputIdZenturie */
	private Long inputIdZenturie;
	
	/** the inputIdManipel */
	private Long inputIdManipel;
	
	/**
	 * The serial UID.
	 */
	private static final long serialVersionUID = -6365094260849608334L;


	@Override
	public String execute() throws Exception {
		zenturieList = zenturieService.loadAll();
		manipelList = manipelService.loadAll();
		
		for(Zenturie zenturie : zenturieList){
			zenturieDisplayMap.put(zenturie.getId(), zenturie.getName());
		}
		zenturieDisplayMap.put((long) -1, "Bitte ausw‰hlen...");
		
		for(Manipel manipel : manipelList) {
			manipelDisplayMap.put(manipel.getId(), manipel.getCourseOfStudy() + 
					manipel.getVintage().toString());
		}
		manipelDisplayMap.put((long) -1, "Bitte ausw‰hlen...");
		
		return SUCCESS;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public HashMap<Long, String> getZenturieDisplayMap() {
		return zenturieDisplayMap;
	}

	public HashMap<Long, String> getManipelDisplayMap() {
		return manipelDisplayMap;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

	public Long getInputIdZenturie() {
		return inputIdZenturie;
	}

	public void setInputIdZenturie(Long inputIdZenturie) {
		this.inputIdZenturie = inputIdZenturie;
	}

	public Long getInputIdManipel() {
		return inputIdManipel;
	}

	public void setInputIdManipel(Long inputIdManipel) {
		this.inputIdManipel = inputIdManipel;
	}

	public void setZenturieDisplayMap(HashMap<Long, String> zenturieDisplayMap) {
		this.zenturieDisplayMap = zenturieDisplayMap;
	}

	public void setManipelDisplayMap(HashMap<Long, String> manipelDisplayMap) {
		this.manipelDisplayMap = manipelDisplayMap;
	}

}
