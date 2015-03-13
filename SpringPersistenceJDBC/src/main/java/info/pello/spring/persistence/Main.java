package info.pello.spring.persistence;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This program makes use of a CustomerDAO that
 * uses Spring JdbcTemplates to manage data.
 * 
 * @author Pello Xabier Altadill Izura
 * @greetz White take away cup
 */
public class Main {
	
	/**
	 * shows all data from Customer table
	 * @param customerDao
	 * @return
	 */
	public static String readAll (CustomerDAO customerDao) {
		String result = "";
		List<Customer> customers = customerDao.getCustomers();
		
		for (Customer customer : customers) {
			result += "Id: " + customer.getId() + ",";
			result += customer.getName() + ",";
			result += customer.getAddress() + ",";
			result += customer.getEmail() + "\n";
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ApplicationContext contexto = new ClassPathXmlApplicationContext("persistencejdbc.xml");
		
		CustomerDAO customerDAO = (CustomerDAO) contexto.getBean("customerDao");
		
		Scanner scanner = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		long id = 0;
		String name = "";
		String address = "";
		String email = "";
		
		// CREATE
		System.out.println("Insert new Name");
		name = scanner.nextLine();
		System.out.println("Insert new Adress");
		address = scanner.nextLine();

		System.out.println("Insert new Email");
		email = scanner.nextLine();
		
		Customer customer = new Customer(0, name, address,email);
		long newId = customerDAO.create(customer);
		System.out.println("New Id added: " + newId);
		
		System.out.println(Main.readAll(customerDAO));
		
		
		System.out.println("Customer data: " + customer.toString());
		
		// UPDATE DATA
		System.out.println("Insert new Name");
		name = scanner.nextLine();
		System.out.println("Insert new Adress");
		address = scanner.nextLine();
		System.out.println("Insert new Email");
		email = scanner.nextLine();

		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		customerDAO.update(customer);

		System.out.println(Main.readAll(customerDAO));
		
		
		// REMOVE
		customerDAO.delete(customer.getId());
		System.out.println(Main.readAll(customerDAO));
		
		// Get By ID
		System.out.println("Select a Id");
		id = scanner.nextLong();
		customer = customerDAO.getCustomersById(id);
		
		System.out.println("Customer is: " + customer.toString());

		
	}

}
