package info.pello.spring.football;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main App
 * @author Pello Xabier Altadill Izura
 * @greetz u 
 */
public class App {

    public static void main (String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("football.xml");
		
		Match match = (Match) context.getBean("match");
                
        System.out.println("Match data: " + match.toString());
    }
}
