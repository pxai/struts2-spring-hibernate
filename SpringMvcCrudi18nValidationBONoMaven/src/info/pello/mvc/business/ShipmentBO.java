package info.pello.mvc.business;

import java.util.List;
import org.apache.log4j.Logger;
import info.pello.mvc.dao.ShipmentDAOInterface;
import info.pello.mvc.model.Shipment;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Holds all the business logic for Shipment related management
 * @author Pello Altadill
 * @greetz Any
 *
 */
public class ShipmentBO implements ShipmentBOInterface {
	
	// Get log4j logger
	private static final Logger logger = Logger.getLogger(ShipmentBO.class);
	
	@Autowired
    private ShipmentDAOInterface shipmentDAO;

	@Override
	public Shipment selectById(int id) {
		logger.info("selectById: " + id);
		return shipmentDAO.selectById(id);
	}

	@Override
	public List<Shipment> selectAll() {
		logger.info("selectAll: ");
		return shipmentDAO.selectAll();
	}

	@Override
	public List<Shipment> search(String description) {
		logger.info("search : " + description);
		return shipmentDAO.search(description);
	}

	@Override
	public void deleteById(int id) {
		logger.info("delete: " + id);
		 shipmentDAO.deleteById(id);
	}

	@Override
	public void insert(Shipment shipment) {
		logger.info("insert: " + shipment);
		shipmentDAO.insert(shipment);
	}

	@Override
	public void update(Shipment shipment) {
		logger.info("update: " + shipment);
		shipmentDAO.update(shipment);
	}
}
