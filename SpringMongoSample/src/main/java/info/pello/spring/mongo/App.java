/**
 * 
 */
package info.pello.spring.mongo;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pello Altadill
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
        ApplicationContext contexto = new ClassPathXmlApplicationContext("springmongo.xml");
        
        MessageDAO messageDAO = (MessageDAO) contexto.getBean("messageDAO");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(messageDAO.select().toString());

	}

}
