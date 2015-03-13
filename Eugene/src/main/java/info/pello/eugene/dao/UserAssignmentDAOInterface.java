package info.pello.eugene.dao;


import info.pello.eugene.model.UserAssignment;

import java.util.List;

/**
 * interface for UserAssignmentDAO class
 * @author Pello Altadill
 *
 */
public interface UserAssignmentDAOInterface {
	
	public UserAssignment selectById(int id);
	public List<UserAssignment> selectAll ();
	public void insert (UserAssignment userAssignment);
	public void update (UserAssignment userAssignment);
	public void delete (UserAssignment userAssignment);
	public void deleteById (int id);
	public List<UserAssignment> search(String description);

}
