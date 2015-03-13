/**
 * 
 */
package org.cuatrovientos.hibernate.simple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Class to do all db related operations for Customer
 * @author Pello Altadill
 * @greetz any
 */
public class CustomerDAO {
	 private  SessionFactory sessionFactory;
     
	 	/**
	 	 * sets SessionFactory in order to get the Hibernate Session
	 	 * @return
	 	 */
	    public SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            // loads configuration and mappings
	            Configuration configuration = new Configuration().configure();
	            ServiceRegistry serviceRegistry
	                = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	             
	            // builds a session factory from the service registry
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
	        }
	         
	        return sessionFactory;
	    }
	    
	    /**
	     * returns all Customers from db
	     * @return
	     */
	    public List<Customer> readAll () {
	    	List<Customer> customers;
	    	Session session = getSessionFactory().getCurrentSession();
	    	
	    	session.getTransaction().begin();  	
	    	customers = session.createQuery("from Customer").list();	    	
	    	session.getTransaction().commit();
	    	
	    	return customers;
	    }
	    
	    /**
	     * persists or saves Customer in db
	     * @return
	     */
	    public void create (Customer customer) {
	    	Session session = getSessionFactory().getCurrentSession();
	    	
	    	session.getTransaction().begin();
	    	session.save(customer);
	    	session.getTransaction().commit();
	    	
	    }
}
