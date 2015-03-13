/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.HashSet;
import java.util.Set;
/**
 * Represents system User role data
 * @author Pello Xabier Altadill Izura
 *
 */
public class Role {
	private long id;
	private String name;
	private String description;
    private Set<User> users = new HashSet<User>();
    
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
	public Role(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
