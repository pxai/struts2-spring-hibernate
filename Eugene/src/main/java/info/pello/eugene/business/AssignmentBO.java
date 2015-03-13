package info.pello.eugene.business;

import java.util.List;
import org.apache.log4j.Logger;
import info.pello.eugene.dao.AssignmentDAOInterface;
import info.pello.eugene.model.Assignment;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Holds all the business logic for Assignment related management
 * @author Pello Altadill
 * @greetz Any
 *
 */
public class AssignmentBO implements AssignmentBOInterface {
	
	// Get log4j logger
	private static final Logger logger = Logger.getLogger(AssignmentBO.class);
	
	@Autowired
    private AssignmentDAOInterface assignmentDAO;

	/**
	 * 
	 */
	public Assignment selectById (int id) {
		logger.info("selectById: " + id);
		return assignmentDAO.selectById(id);
	}

	/**
	 * 
	 */
	public List<Assignment> selectAll() {
		logger.info("selectAll: ");
		return assignmentDAO.selectAll();
	}

	/**
	 * 
	 */
	public List<Assignment> search(String description) {
		logger.info("search : " + description);
		return assignmentDAO.search(description);
	}

	/**
	 * 
	 */
	public void deleteById(int id) {
		logger.info("delete: " + id);
		 assignmentDAO.deleteById(id);
	}

	/**
	 * @param Assigment
	 */
	public void insert(Assignment assignment) {
		logger.info("insert: " + assignment);
		assignmentDAO.insert(assignment);
	}


	public void update(Assignment assignment) {
		logger.info("update: " + assignment);
		assignmentDAO.update(assignment);
	}
}
