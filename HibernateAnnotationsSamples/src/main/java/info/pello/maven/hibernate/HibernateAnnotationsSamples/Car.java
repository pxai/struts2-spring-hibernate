/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

//We need all of these for annotations
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;



/**
 * Represents a company car
 * @author Pello Altadill
 * @greetz Taberna chocolate cake
 */
@Entity
@Table(name="car")
public class Car {
	
	@Id
    @GeneratedValue
    @Column(name="id")
	private int id;
	
    @Column(name="registration")
    private String registration;
    
	@Column(name="model")
	private String model;
	
    @OneToOne(mappedBy="car", cascade=CascadeType.ALL)
	private Insurance insurance; 
	
	public Car () {
		
	}

	/**
	 * @param id
	 * @param registration
	 * @param model
	 */
	public Car(int id, String registration, String model) {
		this.id = id;
		this.registration = registration;
		this.model = model;
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
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the idinsurance
	 */
	public Insurance getIdinsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setIdinsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the insurance
	 */
	public Insurance getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
}
