/**
 * 
 */
package info.pello.struts.validacionxml;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Pello Altadill
 *
 */
public class Simple extends ActionSupport {

	private String saludo;
	private String name;
	private String password1;
	private String password2;
	private String email;
	private String cp;
	private String submit;
	


	@Override
    public String execute()
    {
		
    	saludo = "Ok, datos recibidos, gracias " + name;
        
        return SUCCESS;
    }
	
	
	/**
	 * getSaludo
	 * @return saludo
	 */
    public String getSaludo() {
		return saludo;
	}

    /**
     * setSaludo
     * @param saludo
     */
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword1(String password) {
		this.password1 = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword2(String password) {
		this.password2 = password;
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
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
}
