package info.pello.eugene.business;

import java.util.List;

import info.pello.eugene.model.Assignment;



/**
 * interface to define all Assignment related operations
 * @author Pello Altadill
 * @greetz Any 
 */
public interface AssignmentBOInterface {
	public Assignment selectById(int id);

	public List<Assignment> selectAll();

	public List<Assignment> search(String description);

	public void deleteById(int id);

	public void insert(Assignment assignment);

	public void update(Assignment assignment);

}
