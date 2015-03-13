/**
 * 
 */
package info.pello.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.Level;
import org.apache.log4j.Logger;  

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
		Logger logger = Logger.getLogger(Main.class);
		
		// log4j error levels DEBUG < INFO < WARN < ERROR < FATAL
		// By default it will show INFO, ERROR, FATAL
		// We could change programatically...
		logger.setLevel(Level.ALL);
		
		logger.info("Info message");  
		logger.trace("Simple trace"); 
		logger.debug("Debug message. ");  
		logger.error("Error message");  
		logger.fatal("Fatal error");  
		
		System.out.println(greetingEngine.greetMe());
		
	}

}
