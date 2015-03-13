/**
 * 
 */
package info.pello.runningbulls;

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
		RunningOfTheBulls runningOfTheBulls = new RunningOfTheBulls();
		runningOfTheBulls.makeThemRun();
		
		System.out.println(runningOfTheBulls.deadReport());
		
	}

}
