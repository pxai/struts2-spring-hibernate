/**
 * 
 */
package info.pello.runningbulls;

import java.util.Random;
import java.util.Vector;

/**
 * It creates a crowd of human runners for the running
 * @author Pello Altadill
 * @greetz Snowden
 */
public class HumanCrowd extends Vector<Human> {
	private int totalRunners;
	
	/**
	 * constructor, calls init to create the crowd
	 * @param total Runners to create
	 */
	public HumanCrowd(int totalRunners) {
		this.totalRunners = totalRunners;
		init();
	}

	/**
	 * creates human runners Vector
	 */
	private void init() {
		Random random = new Random();
		// We create runners
		for (int i = 0; i < totalRunners; i++ ) {
			this.add(new Human("Runner_"+i,random.nextInt(6) + 1));
		}
	}

	
}
