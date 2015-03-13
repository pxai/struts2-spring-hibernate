/**
 * 
 */
package info.pello.runningbulls;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;


/**
 * Fires the running of the bulls
 * @author Pello Altadill
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext contexto = new ClassPathXmlApplicationContext("hellospring.xml");
		
		RunningOfTheBulls runningOfTheBulls = (RunningOfTheBulls) contexto.getBean("runningbulls");
		runningOfTheBulls.makeThemRun();
		
		System.out.println(runningOfTheBulls.deadReport());
		
	}

}
