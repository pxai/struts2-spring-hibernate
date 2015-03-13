package info.pello.eugene.business;

import java.util.List;

import info.pello.eugene.model.UserAssignment;



/**
 * interface to define all userAssignment related operations
 * @author Pello Altadill
 * @greetz Any 
 */
public interface UserAssignmentBOInterface {
	public UserAssignment selectById(int id);

	public List<UserAssignment> selectAll();

	public List<UserAssignment> search(String description);

	public void deleteById(int id);

	public void insert(UserAssignment userAssignment);

	public void update(UserAssignment userAssignment);

}
