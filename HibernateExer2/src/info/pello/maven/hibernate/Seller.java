package info.pello.maven.hibernate;

import java.util.Set;

/**
 * 
 */


/**
 * Represents data from a Seller
 * @author Pello Xabier Altadill Izura
 *
 */
public class Seller {
	private int id;
	private String name;
	private Float percentage;
	private Set<Sale> sales;

	
	/**
	 * default constructor
	 */
	public Seller () {
		
	}
	
	/**
	 * Constructor with all attributes
	 * @param id
	 * @param name
	 * @param percentage
	 */
	public Seller(int id, String name, Float percentage,Set<Sale> sales) {
		this.id = id;
		this.name = name;
		this.percentage = percentage;
		this.sales = sales;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the percentage
	 */
	public Float getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the sales
	 */
	public Set<Sale> getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	
	
	
}
