package info.pello.maven.hibernate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;



/**
 * Represents Sale data
 * @author Pello Xabier Altadill Izura
 *
 */
@Entity
@Table(name="sale")
public class Sale {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="description")
	private String description;

	@Column(name="saledate")
	private Date saledate;
	
	@Column(name="idseller")
	private int idseller;
	
	@ManyToOne
	@JoinColumn(name="idseller", insertable= false, updatable= false)
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
