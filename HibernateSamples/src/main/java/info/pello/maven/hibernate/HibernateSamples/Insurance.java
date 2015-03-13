/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

/**
 * Represents the insurance for a car
 * @author Pello Xabier Altadill Izura
 *
 */
public class Insurance {
	private int idcar;
	private String company;
	private String type;
	private double cost;
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
