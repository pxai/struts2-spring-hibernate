package org.cuatrovientos.struts;

import java.util.Set;
/**
 * 
 */


/**
 * Represents data from a Customer
 * @author Pello Xabier Altadill Izura
 *
 */
public class Role {
	private int id;
	private String name;
	private String description;
	private Set<User> users;
	
	/**
	 * default constructor
	 */
	public Role () {
		
	}
	
	/**
	 * Constructor with all attributes
	 * @param id
	 * @param name
	 * @param description
	 */
	public Role(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	/**
	 * @param address the address to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
