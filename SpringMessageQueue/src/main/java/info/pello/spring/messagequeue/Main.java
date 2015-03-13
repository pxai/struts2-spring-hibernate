/**
 * 
 */
package info.pello.spring.messagequeue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Main program, starting point of our project
 * @author Pello Altadill
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("messagequeue.xml");
		 
		MessageSender messageSender = (MessageSender) context.getBean("messageSender");
		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");

		messageSender.start();
		messageReceiver.start();
		
	}

}
