/**
 * 
 */
package org.cuatrovientos.hibernate.simple;

/**
 * POJO representing a Customer
 * @author Pello Altadill
 * @greetz any
 */
public class Customer {
	private int id;
	private String name;
	private String address;
	
	/**
	 * default constructor
	 */
	public Customer () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Customer(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}

	
}
