/**
 * 
 */
package org.cuatrovientos.struts;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * Main simple sample Struts2 action
 * @author Pello Altadill
 *
 */
public class Main extends ActionSupport  implements ModelDriven<Customer>{

	private String message;
	private Customer customer = new Customer();
	private CustomerDAO customerDAO = new CustomerDAO();
	private List<Customer> customers = new ArrayList<Customer>();
	
	@Override
	public Customer getModel() {
		return customer;
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
		customers = customerDAO.selectAll();
		System.out.println("Main action> Select all DAO done");
		message = "Select all";
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
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	
}
