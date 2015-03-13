package org.cuatrovientos.struts;
/**
 * 
 */


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * implementation of customerDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class CustomerDAO implements CustomerDAOInterface {

	private Session session;
	

	/**
	 * default constructor
	 */
	public CustomerDAO () {
		session = HibernateSession.getSession();
	}
	
	/* 
	 * selects one customer by Id
	 * @param id
	 * @return Customer
	 */
	public Customer selectById(int id) {
	    Customer customer = (Customer) session.get(Customer.class, id);
	    return customer;
	}

	/*
	 * retrieves all customers from db
	 * @return List of customers
	 */
	public List<Customer> selectAll() {
	 
	    List<Customer> customers = session.createQuery("from Customer").list();
	    return customers;
	}

	/*
	 * inserts a new customer in database
	 * retrieves generated id and sets to customer instance
	 * @param new customer
	 */
	public void insert(Customer customer) {
	    session.beginTransaction();
	 
	    Integer id = (Integer) session.save(customer);
	    customer.setId(id);
	         
	    session.getTransaction().commit();
	         
	}

	/*
	 * updates customer
	 * @param customer to update
	 */
	public void update(Customer customer) {
		 
		    session.beginTransaction();
		 
		    session.merge(customer);
		 
		    session.getTransaction().commit();
		 
	}

	/*
	 * delete given customer
	 * @param customer to delete
	 */
	public void delete(Customer customer) {
	    
	    session.beginTransaction();
	    
	    session.delete(customer);
	 
	    session.getTransaction().commit();
	 
	}

}
