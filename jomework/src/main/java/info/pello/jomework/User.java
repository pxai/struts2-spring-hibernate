/**
 * 
 */
package info.pello.jomework;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents User entity
 * @author Pello Xabier Altadill Izura
 * @greet to teachers who are users too
 */
public class User {
	private Long id;
	
	@Size(min=4,max=30,message="Login must be between 4 and 40 characters long")
	@Pattern(regexp="[A-Za-z0-9]+",message="Must contain conly chars and numbers")
	private String login;

	@Size(min=8,max=15,message="Passowrd must be between 8 and 15 characters long")
	private String password;

	@Size(min=10,max=255,message="Description must be between 10 and 255 characters long")
	private String description;
	
	/**
	 * default constructor
	 */
	public User () {
		
	}

	
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param description
	 */
	public User(Long id, String login, String password, String description) {
		this.id = id;
		this.login = login;		
		this.password = password;
		this.description = description;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User> [id=" + id + ", login=" + login + ", password=" + password
				+ ", description=" + description + "]";
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	


	
	
}
