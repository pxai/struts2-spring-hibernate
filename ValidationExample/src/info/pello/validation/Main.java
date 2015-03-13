/**
 * 
 */
package info.pello.validation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * Simple app to test java Bean validation 
 * @author Pello Altadill
 * @greetz to any
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// We create validator instance
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Customer customer = new Customer(1,"pepe","juan",new Date());
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

		System.out.println("Customer created: " + customer.toString());
		System.out.println("Any constraint violations:");
		if (violations.isEmpty()) {
			System.out.println("Customer seems OK");
		} else {
			System.out.println("Some errors in bean:");
			for (ConstraintViolation<Customer> violation : violations) {
				System.out.println(violation.getMessage());
				System.out.println(violation.toString());
			}
		}
	
	}

}
