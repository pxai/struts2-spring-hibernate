package info.pello.spring.messagequeue;

import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


/**
 * Receives messages to apache MQ
 * @author Pello Altadill
 * @greetz to people I met in Andersen
 */
public class MessageReceiver extends Thread {
	
	private Random random;
	private String queueName;
	private JmsTemplate jmsTemplate;
	
	/**
	 * default constructor
	 */
	public MessageReceiver (String name) {
		super(name);
		random = new Random();
	}
	
	/**
	 * main thread loop
	 */
	public void run () {
		Order order = null;
		int counter = 0;
		
		while (true) {
			try {
				sleep(random.nextInt(5));
				order = receiveMessage();
				
				if (null != order) {
					counter++;
					System.out.println("["+counter+"] Order rcv: " + order.toString());
				} else {
					System.out.println("Order is null ");					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * reads message from queue
	 * @return Order
	 */
	private Order receiveMessage() {
		try {
			ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive(queueName);
			Order order = (Order) receivedMessage.getObject();
			
			return order;
			} catch (JMSException jmsException) {
				System.err.println("Error reading msg: " + jmsException.getMessage());
			}
		
		return null;
		
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
