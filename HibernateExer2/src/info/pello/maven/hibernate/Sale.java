package info.pello.maven.hibernate;

import java.util.Date;



/**
 * Represents Sale data
 * @author Pello Xabier Altadill Izura
 *
 */
public class Sale {
	private int id;
	private String description;
	private Date saledate;
	private int idseller;
	private Seller seller;

	
	/**
	 * default constructor
	 */
	public Sale () {
		
	}


	/**
	 * @param id
	 * @param description
	 * @param saledate
	 * @param idseller
	 * @param seller
	 */
	public Sale(int id, String description, Date saledate, int idseller,
			Seller seller) {
		this.id = id;
		this.description = description;
		this.saledate = saledate;
		this.idseller = idseller;
		this.seller = seller;
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
	 * @return the saledate
	 */
	public Date getSaledate() {
		return saledate;
	}


	/**
	 * @param saledate the saledate to set
	 */
	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}


	/**
	 * @return the idseller
	 */
	public int getIdseller() {
		return idseller;
	}


	/**
	 * @param idseller the idseller to set
	 */
	public void setIdseller(int idseller) {
		this.idseller = idseller;
	}


	/**
	 * @return the seller
	 */
	public Seller getSeller() {
		return seller;
	}


	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	

}
