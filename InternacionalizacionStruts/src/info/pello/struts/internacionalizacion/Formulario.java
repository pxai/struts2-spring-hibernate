/**
 * 
 */
package info.pello.struts.internacionalizacion;


import com.opensymphony.xwork2.ActionSupport;

/**
 * Formulario
 * Formulario que hace uso de la internacionalización
 * @author Pello Altadill
 * 
 */
public class Formulario extends ActionSupport {


	private String name;
	private String password;
	private String description;
	
	@Override
	public String execute () {
		return SUCCESS;
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
