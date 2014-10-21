package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ZenturieDAO;
import de.nak.studentsdatabase.model.Zenturie;

/**
 * The zenturie interface implementation class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class ZenturieServiceImpl implements ZenturieService {
	
	/**
	 * The zenturieDAO
	 */
	private ZenturieDAO zenturieDAO;

	
	@Override
	public void save(Zenturie zenturie) {
		zenturieDAO.save(zenturie);

	}

	@Override
	public Zenturie load(Long id) {
		return zenturieDAO.load(id);
	}

	@Override
	public void delete(Zenturie zenturie) {
		zenturieDAO.delete(zenturie);

	}

	@Override
	public List<Zenturie> loadAll() {
		return zenturieDAO.loadAll();
	}

}
