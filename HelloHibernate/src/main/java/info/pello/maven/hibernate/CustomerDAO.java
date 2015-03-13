package info.pello.maven.hibernate;
/**
 * 
 */


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of customerDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class CustomerDAO implements CustomerDAOInterface {

	/* 
	 * selects one customer by Id
	 * @param id
	 * @return Customer
	 */
	public Customer selectById(long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Customer customer = (Customer) session.get(Customer.class, id);
	    session.close();
	    return customer;
	}

	/*
	 * retrieves all customers from db
	 * @return List of customers
	 */
	public List<Customer> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Customer> customers = session.createQuery("from Customer").list();
	    session.close();
	    return customers;
	}

	/*
	 * inserts a new customer in database
	 * retrieves generated id and sets to customer instance
	 * @param new customer
	 */
	public void insert(Customer customer) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    Long id = (Long) session.save(customer);
	    customer.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates customer
	 * @param customer to update
	 */
	public void update(Customer customer) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(customer);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * delete given customer
	 * @param customer to delete
	 */
	public void delete(Customer customer) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(customer);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
