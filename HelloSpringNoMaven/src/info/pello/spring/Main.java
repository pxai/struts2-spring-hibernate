/**
 * 
 */
package info.pello.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main program, starting point of our project
 * @author Pello Altadill
 * @greetz Spring adepts
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("greetings.xml");
		 
		GreetingEngine greetingEngine = (GreetingEngine) context.getBean("greetingEngine");
		
		System.out.println(greetingEngine.greetMe());
		
	}

}
