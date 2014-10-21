package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.CompanyDAO;
import de.nak.studentsdatabase.model.Company;

public class CompanyServiceImpl implements CompanyService {
	
	/**
	 * The companyDAO
	 */
	CompanyDAO companyDAO;

	@Override
	public void save(Company company) {
		companyDAO.save(company);

	}

	@Override
	public Company load(Long id) {
		return companyDAO.load(id);
	}

	@Override
	public void delete(Company company) {
		companyDAO.delete(company);

	}

	@Override
	public List<Company> loadAll() {
		return companyDAO.loadAll();
	}

}
