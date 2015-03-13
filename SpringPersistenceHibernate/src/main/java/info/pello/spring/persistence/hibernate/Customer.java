package info.pello.spring.persistence.hibernate;

/**
 * 
 */

/**
 * POJO class for Customer
 * @author Pello Altadill
 *
 */
public class Customer {
	private long id;
	private String name;
	private String address;	
	private String email;
	
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
	public Customer(long id, String name, String address, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
	/********** Getters/Setters ********************/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
