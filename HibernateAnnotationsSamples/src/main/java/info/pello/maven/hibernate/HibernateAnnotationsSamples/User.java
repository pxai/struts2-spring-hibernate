/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Represents system User data
 * @author Pello Xabier Altadill Izura
 *
 */
@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;

	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;

	@Column(name="email")
	private String email;
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="userrole", 
                joinColumns={@JoinColumn(name="iduser")}, 
                inverseJoinColumns={@JoinColumn(name="idrole")})
    private Set<Role> roles = new HashSet<Role>();
	
	/**
	 * default constructor
	 */
	public User () {
		
	}
	
	/**
	 * Constructor with all attributes
	 * @param id
	 * @param login
	 * @param password
	 * @param email
	 */
	public User(long id, String login, String password, String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
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
	public String getLogin() {
		return login;
	}
	/**
	 * @param name the name to set
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
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
