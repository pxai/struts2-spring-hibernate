package info.pello.maven.spring.Javamon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main App
 * @author Pello Altadill
 * @greetz u and to all DAM1 sick people, go and get a life
 */
public class App {

    public static void main (String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("javamon.xml");
		
		Combat combat = (Combat) context.getBean("combat");
        
        combat.combat();
        
        System.out.println("And the winner is: " + combat.outcome().getName());
        
        System.out.println("Thanks for playing javamon");
    }
}
