/**
 * 
 */
package info.pello.eugene.model;

import java.sql.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author luser
 *
 */
public class Shipment {
	
	private int id;
	
	@Size(min=2,max=100,message="{shipment.description.error}")
	private String description;
	
	@Past(message="{shipment.shipmentDate.error}")
	private java.sql.Date shipmentDate;
	
	@Size(min=2,max=100,message="{shipment.origin.error}")
	private String origin;
	
	@Size(min=2,max=100,message="{shipment.destiny.error}")
	private String destiny;
	
	public Shipment () {
		
	}

	
	/**
	 * @param id
	 * @param description
	 * @param shipmentDate
	 * @param origin
	 * @param destiny
	 */
	public Shipment(int id, String description, Date shipmentDate,
			String origin, String destiny) {
		this.id = id;
		this.description = description;
		this.shipmentDate = shipmentDate;
		this.origin = origin;
		this.destiny = destiny;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the shipmentDate
	 */
	public java.sql.Date getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * @param shipmentDate the shipmentDate to set
	 */
	public void setShipmentDate(java.sql.Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destiny
	 */
	public String getDestiny() {
		return destiny;
	}

	/**
	 * @param destiny the destiny to set
	 */
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", description=" + description
				+ ", shipmentDate=" + shipmentDate + ", origin=" + origin
				+ ", destiny=" + destiny + "]";
	}
	
	

}
