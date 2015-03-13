package info.pello.mvc.business;

import java.util.List;

import info.pello.mvc.model.Shipment;



/**
 * interface to define all shipment related operations
 * @author Pello Altadill
 * @greetz Any 
 */
public interface ShipmentBOInterface {
	public Shipment selectById(int id);

	public List<Shipment> selectAll();

	public List<Shipment> search(String description);

	public void deleteById(int id);

	public void insert(Shipment shipment);

	public void update(Shipment shipment);

}
