package org.cuatrovientos.hibernate.simple;

import java.util.List;

/**
 * Main program for hibernate simple project
 * @author Pello Altadill
 * @greetz any
 */
public class App 
{
    public static void main( String[] args ) {
    	CustomerDAO customerDAO = new CustomerDAO();
    	
    	Customer customer = new Customer();
    	customer.setName("Mr. Smith");
    	customer.setAddress("City of Zion");
    	
    	customerDAO.create(customer);
    	
    	List<Customer> customers = customerDAO.readAll();
    	
    	for (Customer c : customers) {
    		System.out.println(c.toString());
    	}
    	
    }
}
