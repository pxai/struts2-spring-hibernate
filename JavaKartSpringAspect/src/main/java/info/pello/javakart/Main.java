/**
 * 
 */
package info.pello.javakart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Inits JavaKart race
 * @author Pello Altadill
 * @greetz for the blue mug
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("javakart.xml");
        
        Race race = (Race) context.getBean("race");
        
        System.out.println(race.toString());
        race.run();
        System.out.println(race.showResult());

	}

}
