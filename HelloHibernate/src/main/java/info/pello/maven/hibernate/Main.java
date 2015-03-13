package info.pello.maven.hibernate;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Main class
 * @author Pello Xabier Altadill Izura
 * @greetz 4 u
 * @listening "Seasons in the Abyss - Slayer"
 * Close your eyes 
 * Look deep in your soul 
 * Step outside yourself 
 * And let your mind go 
 * Frozen eyes stare deep in your mind as you die 
 */
public class Main  {
	
	
	/**
	 * simple function for reusing
	 * @param customerDAO
	 */
	public static void showAll (CustomerDAO customerDAO) {
		// SELECT ALL DATA
    	List<Customer> customers = customerDAO.selectAll();
        
    	System.out.println("\n--- CUSTOMER ----- table contents -----------");
        
        for(Customer customer : customers) {
        	System.out.print("Id: " + customer.getId());
        	System.out.println(" - Name: " + customer.getName());
        }

        System.out.println("Total Customers: " + customers.size());	
	}
	

	
	/**
	 * main function
	 * @param args
	 */
    public static void main( String[] args )
    {
    	
    	CustomerDAO customerDAO = new CustomerDAO();
    	showAll(customerDAO);
            
        // SELECT JUST ONE
        Customer oneCustomer = customerDAO.selectById(1);
    	System.out.println("Selected Name: " + oneCustomer.getName());
    	
        // INSERT NEW DATA
    	Customer newCustomer = new Customer(0,"Phil Anselmo","Suicide note","phil@pantera.com");
    	customerDAO.insert(newCustomer);
    	System.out.println("Inserted id: " + newCustomer.getId());
    	
        System.out.println("Show data after new insert");
    	showAll(customerDAO);
        
        // UPDATE DATA
        newCustomer.setName("Dimebag Darrell");
        customerDAO.update(newCustomer);

        System.out.println("Show data after update");
    	showAll(customerDAO);
        
        // DELETE DATA
        customerDAO.delete(newCustomer);

        System.out.println("Show data after deletion");
    	showAll(customerDAO);
     
    }
}
