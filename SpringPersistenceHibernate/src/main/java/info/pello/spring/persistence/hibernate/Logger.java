/**
 * 
 */
package info.pello.spring.persistence.hibernate;

/**
 * Aspect to log about DAO operations
 * @author Pello Xabier Altadill
 * @greetz SpongeBob
 */
public class Logger {
	public void reportInsert (Customer customer) {
		System.out.println("Customer INSERTED: " + customer.toString());
	}
}
