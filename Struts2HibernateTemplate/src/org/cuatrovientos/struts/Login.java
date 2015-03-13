/**
 * 
 */
package org.cuatrovientos.struts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Hello simple sample Struts2 action
 * @author Pello Altadill
 *
 */
public class Login extends ActionSupport {

	private String message;
	private String login;
	private String password;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("Login action> Execute");

		if (login.equals("falken") && password.equals("josua")) {
			message = "Welcome to Struts2 template";
			return SUCCESS;
		} else {
			message = "Login incorrect";
			return ERROR;
		}
	}

	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#input()
	 */
	@Override
	public String input() throws Exception {
		System.out.println("Login action> Input");
		return super.input();
		
	}



	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	
}
