/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

// We need all of these for annotations
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Represents the insurance for a car
 * @author Pello Xabier Altadill Izura
 * @greetz Taberna chocolate cake
 */
@Entity
@Table(name="insurance")
public class Insurance {
	
	@Id
    @Column(name="idcar", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="car"))
	private int idcar;
    
	@Column(name="company")
	private String company;
    
    @Column(name="type")
	private String type;
    
    @Column(name="cost")
	private double cost;
	
    @OneToOne
    @PrimaryKeyJoinColumn
    private Car car;
	
	public Insurance () {
		
	}

	/**

	 * @param company
	 * @param type
	 * @param cost
	 */
	public Insurance(String company, String type, double cost) {

		this.company = company;
		this.type = type;
		this.cost = cost;
	}

	/**
	 * @return the id
	 */
	public int getIdcar() {
		return idcar;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdcar(int idcar) {
		this.idcar = idcar;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
