package info.pello.eugene.business;

import java.util.List;
import org.apache.log4j.Logger;
import info.pello.eugene.dao.UserAssignmentDAOInterface;
import info.pello.eugene.model.UserAssignment;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Holds all the business logic for UserAssignment related management
 * @author Pello Altadill
 * @greetz Any
 *
 */
public class UserAssignmentBO implements UserAssignmentBOInterface {
	
	// Get log4j logger
	private static final Logger logger = Logger.getLogger(UserAssignmentBO.class);
	
	@Autowired
    private UserAssignmentDAOInterface userAssignmentDAO;


	public UserAssignment selectById(int id) {
		logger.info("selectById: " + id);
		return userAssignmentDAO.selectById(id);
	}


	public List<UserAssignment> selectAll() {
		logger.info("selectAll: ");
		return userAssignmentDAO.selectAll();
	}


	public List<UserAssignment> search(String description) {
		logger.info("search : " + description);
		return userAssignmentDAO.search(description);
	}


	public void deleteById(int id) {
		logger.info("delete: " + id);
		 userAssignmentDAO.deleteById(id);
	}


	public void insert(UserAssignment userAssignment) {
		logger.info("insert: " + userAssignment);
		userAssignmentDAO.insert(userAssignment);
	}


	public void update(UserAssignment userAssignment) {
		logger.info("update: " + userAssignment);
		userAssignmentDAO.update(userAssignment);
	}
}
