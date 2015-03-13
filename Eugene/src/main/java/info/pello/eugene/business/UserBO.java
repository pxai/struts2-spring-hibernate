package info.pello.eugene.business;

import java.util.List;
import org.apache.log4j.Logger;
import info.pello.eugene.dao.UserDAOInterface;
import info.pello.eugene.model.User;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Holds all the business logic for User related management
 * @author Pello Altadill
 * @greetz Any
 *
 */
public class UserBO implements UserBOInterface {
	
	// Get log4j logger
	private static final Logger logger = Logger.getLogger(UserBO.class);
	
	@Autowired
    private UserDAOInterface userDAO;

	public User selectById(int id) {
		logger.info("selectById: " + id);
		return userDAO.selectById(id);
	}


	public List<User> selectAll() {
		logger.info("selectAll: ");
		return userDAO.selectAll();
	}


	public List<User> search(String description) {
		logger.info("search : " + description);
		return userDAO.search(description);
	}


	public void deleteById(int id) {
		logger.info("delete: " + id);
		 userDAO.deleteById(id);
	}


	public void insert(User user) {
		logger.info("insert: " + user);
		userDAO.insert(user);
	}


	public void update(User user) {
		logger.info("update: " + user);
		userDAO.update(user);
	}
}
