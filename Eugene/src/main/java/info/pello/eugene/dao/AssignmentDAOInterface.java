package info.pello.eugene.dao;


import info.pello.eugene.model.Assignment;

import java.util.List;

/**
 * interface for ShipmentDAO class
 * @author Pello Altadill, with regards for Daniel Lacasta
 *
 */
public interface AssignmentDAOInterface {
	
	public Assignment selectById(int id);
	public List<Assignment> selectAll ();
	public void insert (Assignment shipment);
	public void update (Assignment shipment);
	public void delete (Assignment shipment);
	public void deleteById (int id);
	public List<Assignment> search(String description);

}
