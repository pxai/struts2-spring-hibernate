package info.pello.spring.persistence.hibernate;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * DAO for customer entity using Hibernate
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
@Repository  
public class CustomerDAO {

	private SessionFactory sessionFactory;

	public CustomerDAO () {}


	/**
	 * gives hibernate3 Session
	 * @return current hibernate Session
	 */
	private Session getSession () {

		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * gets Customer data from DataBase
	 * @param customerId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Customer getCustomersById (long customerId) {
	    Customer customer = (Customer) getSession().get(Customer.class, customerId);
	    return customer;
	} 

	/**
	 * gets all Customer data from DataBase
	 * @return list of customers
	 */
	@Transactional(readOnly = true)
	public List<Customer> getCustomers () {
		List<Customer> customers = null;

	    customers = getSession().createQuery("from Customer").list();

	    return customers;
	} 
	
	/**
	 * creates new Customer
	 * @param newCustomer
	 * @return
	 */
	@Transactional
	public long create (Customer newCustomer) {

		//getSession().beginTransaction();
		 
	    Long id = (Long) getSession().save(newCustomer);
	    newCustomer.setId(id);
	         
	    //getSession().getTransaction().commit();
	         
		return id;
	}
	
	/**
	 * updates customer information 
	 * @param customer
	 * @return affected rows
	 */
	@Transactional
	public int update (Customer customer) {
		
		getSession().merge(customer);
		return 0;
	}
	
	/**
	 * delete customer  
	 * @param customerId
	 * @return affected rows
	 */
	@Transactional
	public int delete (Long customerId) {;
	    
		// It's easier to delete using the object.. but
		// just to see how we should delete by id:
	 	Customer customerToDelete = (Customer) sessionFactory.getCurrentSession().load(Customer.class,customerId);
	 	getSession().delete(customerToDelete);
		return 0;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		if (sessionFactory.isClosed()) {System.out.println("Su puta m,adre");}
	}




}
