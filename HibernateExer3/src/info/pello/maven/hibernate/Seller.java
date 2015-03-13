package info.pello.maven.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * Represents data from a Seller
 * @author Pello Xabier Altadill Izura
 *
 */
@Entity
@Table(name="seller")
public class Seller {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="percentage")
	private Float percentage;
	
	@OneToMany(mappedBy="seller")
	@Fetch(FetchMode.JOIN)
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
