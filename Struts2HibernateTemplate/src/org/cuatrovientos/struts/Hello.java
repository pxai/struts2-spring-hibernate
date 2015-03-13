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
public class Hello extends ActionSupport {

	private String message;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		message = "Welcome to Struts2 template";
		return SUCCESS;
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
	
}
