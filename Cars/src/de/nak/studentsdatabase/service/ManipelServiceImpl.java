package de.nak.studentsdatabase.service;

import java.util.List;

import de.nak.studentsdatabase.dao.ManipelDAO;
import de.nak.studentsdatabase.model.Manipel;

public class ManipelServiceImpl implements ManipelService {
	
	/**
	 * The manipelDAO.
	 */
	private ManipelDAO manipelDAO;

	@Override
	public void save(Manipel manipel) {
		manipelDAO.save(manipel);

	}

	@Override
	public Manipel load(Long id) {
		return manipelDAO.load(id);
	}

	@Override
	public void delete(Manipel manipel) {
		manipelDAO.delete(manipel);

	}

	@Override
	public List<Manipel> loadAll() {
	return manipelDAO.loadAll();
	}

	public void setManipelDAO(ManipelDAO manipelDAO) {
		this.manipelDAO = manipelDAO;
	}

	
	
	

}
