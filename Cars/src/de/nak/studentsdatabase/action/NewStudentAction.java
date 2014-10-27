package de.nak.studentsdatabase.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.model.Manipel;
import de.nak.studentsdatabase.model.Zenturie;
import de.nak.studentsdatabase.service.CompanyService;
import de.nak.studentsdatabase.service.ManipelService;
import de.nak.studentsdatabase.service.ZenturieService;

/**
 * The action that provides the lists for company and caretaker
 * 
 * @author Dirk Johannﬂen
 *
 */
public class NewStudentAction implements Action {
	
	/** the companyService */
	private CompanyService companyService; 
	
	/** the zenturieService */
	private ZenturieService zenturieService;
	
	/** the manipelService */
	private ManipelService manipelService; 
	
	/** the companyList */
	private List<Company> companyList;
	
	/** the manipelList */
	private List<Manipel> manipelList;
	
	/** the zenturieList */
	private List<Zenturie> zenturieList;

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	@Override
	public String execute() throws Exception {
		companyList = companyService.loadAll();
		manipelList = manipelService.loadAll();
		zenturieList = zenturieService.loadAll();
		return SUCCESS;
	}

	public List<Manipel> getManipelList() {
		return manipelList;
	}

	public List<Zenturie> getZenturieList() {
		return zenturieList;
	}

	public void setZenturieService(ZenturieService zenturieService) {
		this.zenturieService = zenturieService;
	}

	public void setManipelService(ManipelService manipelService) {
		this.manipelService = manipelService;
	}

}
