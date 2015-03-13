/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

/**
 * Represents a company car
 * @author Pello Altadill
 *
 */
public class Car {
	private int id;
	private String registration;
	private String model;
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
