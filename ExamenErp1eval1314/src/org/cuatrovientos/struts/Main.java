/**
 * 
 */
package org.cuatrovientos.struts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * Main simple sample Struts2 action
 * @author Pello Altadill
 *
 */
public class Main extends ActionSupport  
	implements ModelDriven<User>{

	private String message;
	private int roleid;
	private User user = new User();
	private UserDAO userDAO = new UserDAO();
	private RoleDAO roleDAO = new RoleDAO();
	private List<User> users;
	private List<Role> roles;
	
	@Override
	public User getModel() {
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
		System.out.println("Main > Validate");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("Main action> execute");
		roles = roleDAO.selectAll();
		message = "Main action";
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String selectAll()
	{
		System.out.println("Main action> Select all");
		roles = roleDAO.selectAll();
		users = userDAO.selectAll();
		System.out.println("Main action> Select all DAO done");
		message = "Select all";
		return SUCCESS;
	}
	
	/**
	 * handler for delete action
	 */
	public String delete () {
		System.out.println("Main action> delete");
		HttpServletRequest request = 
				(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		int id = Integer.parseInt(request.getParameter("id"));
		User doomedCustomer = userDAO.selectById(id);
		System.out.println("Main action> delete: " + id);
		doomedCustomer.setId(id);
		userDAO.delete(doomedCustomer);
		return SUCCESS;
		
	}

	/**
	 * To list all users.
	 * @return String
	 */
	public String selectRoles()
	{
		HttpServletRequest request = 
				(HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		roleid = Integer.parseInt(request.getParameter("roleid"));
		System.out.println("Main action> Select from role: " + roleid);
		roles = roleDAO.selectAll();
		users = userDAO.selectRoles(roleid);
		message = "Select users from roles";
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

	/**
	 * @return the customer
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the customers
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}


	
}
