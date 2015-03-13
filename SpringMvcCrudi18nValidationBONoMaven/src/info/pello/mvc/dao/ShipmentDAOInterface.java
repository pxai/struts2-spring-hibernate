package info.pello.mvc.dao;


import info.pello.mvc.model.Shipment;

import java.util.List;

/**
 * interface for ShipmentDAO class
 * @author Pello Altadill, with regards for Daniel Lacasta
 *
 */
public interface ShipmentDAOInterface {
	
	public Shipment selectById(int id);
	public List<Shipment> selectAll ();
	public void insert (Shipment shipment);
	public void update (Shipment shipment);
	public void delete (Shipment shipment);
	public void deleteById (int id);
	public List<Shipment> search(String description);

}
