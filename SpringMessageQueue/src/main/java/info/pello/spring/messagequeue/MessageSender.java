package info.pello.spring.messagequeue;

import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


/**
 * Sends messages to apache MQ
 * @author Pello Altadill
 * @greetz to people I met in Andersen
 */
public class MessageSender extends Thread {

	private Random random;
	private JmsTemplate jmsTemplate;
	private String queueName;
	
	/**
	 * default constructor
	 */
	public MessageSender (String name) {
		super(name);
		random = new Random();
	}
	
	/**
	 * main thread loop
	 */
	public void run () {
		String [] products = {"BigMac","Chips","Coke"};
		Order order = null;
		int counter = 0;
		
		while (true) {
			try {
				sleep(random.nextInt(5));
				counter++;
				order = new Order(products[random.nextInt(3)], random.nextInt(5));
				System.out.println("["+counter+"] Sending order: " + order.toString());
				sendMessage(order);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * sends message to queue
	 * http://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch23s03.html
	 * @param order
	 */
	private void sendMessage(final Order order) {

		jmsTemplate.send(queueName,
			new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createObjectMessage(order);
				}
			}
		);

		
	}

	/**
	 * @return the jmsTemplate
	 */
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	/**
	 * @param jmsTemplate the jmsTemplate to set
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
}
