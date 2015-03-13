/**
 * 
 */
package info.pello.eugene.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Represents a User
 * @author pello altadill
 * @greetz 4 any
 */
public class User {
	
	private int id;
	
	@Size(min=2,max=100,message="{user.name.error}")
	private String name;
	
	@Size(min=2,max=50,message="{user.login.error}")
	private String login;
	
	//TODO: @Email 
	@Size(min=2,max=100,message="{user.password.error}")
	private String password;
	
	@Size(min=2,max=100,message="{user.email.error}")
	private String email;

	@Past(message="{user.since.error}")
	private java.sql.Timestamp since;
	
	private int groupId;

	/**
	 * default constructor
	 */
	public User () {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param login
	 * @param password
	 * @param email
	 * @param since
	 */
	public User(int id, String name, String login, String password,
			String email, Timestamp since, int groupId) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.since = since;
		this.groupId = groupId;
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

	/**
	 * @return the since
	 */
	public java.sql.Timestamp getSince() {
		return since;
	}

	/**
	 * @param since the since to set
	 */
	public void setSince(java.sql.Timestamp since) {
		this.since = since;
	}

	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login
				+ ", password=" + password + ", email=" + email + ", since="
				+ since + ", groupId=" + groupId + "]";
	}



	
	

}
