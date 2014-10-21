package de.nak.studentendatenbank.service;

import java.util.List;

import de.nak.studentsdatabase.dao.UserDAO;
import de.nak.studentsdatabase.model.User;

/**
 * The user service implementation class.
 * 
 * @author Dirk Johannﬂen
 *
 */
public class UserServiceImpl implements UserService {
	
	/**
	 * The userDAO.
	 */
	private UserDAO userDAO;

	@Override
	public void save(User user) {
		userDAO.save(user);

	}

	@Override
	public User load(Long id) {
		return userDAO.load(id);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);

	}

	@Override
	public List<User> loadAll() {
		return userDAO.loadAll();
	}

}
