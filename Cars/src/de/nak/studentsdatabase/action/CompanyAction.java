package de.nak.studentsdatabase.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.studentsdatabase.model.Company;
import de.nak.studentsdatabase.service.CompanyService;

/**
 * Action for a single company.
 *
 * @author Andreas Krey
 */
public class CompanyAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -3393497662671380262L;
	/** The current company. */
	private Company company;
	/** The company's identifier selected by the user. */
	private Long companyId;
	/** The company service. */
	private CompanyService companyService;

	/**
	 * Saves the company to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		companyService.save(company);
		return SUCCESS;
	}

	/**
	 * Deletes the selected company from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		company = companyService.load(companyId);
		if (company != null) {
			companyService.delete(company);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected company in the company form.
	 *
	 * @return the result string.
	 */
	public String load() {
		company = companyService.load(companyId);
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
		// If the company is not set, the company ID has to be set.
		if (company == null && companyId == null) {
			addActionError(getText("msg.selectCompany")); //Ändern!
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
}
	
