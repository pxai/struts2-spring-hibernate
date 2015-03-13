/**
 * 
 */
package info.pello.runningbulls;

import java.util.Random;

/**
 * This is a generic abstract runner for the race.
 * We'll extend this class to Bull or Human
 * @author Pello Altadill
 * @greetz for anyone reading this.
 */
public abstract class Runner {
	
	protected String name;
	protected int speed;
	protected int x;
	protected int y;
	protected Random random = new Random();
	private final static int MAX_SPEED = 3;

	/**
	 * Default constructor
	 * @param name
	 * @param speed
	 */
	public Runner(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}
	
	/**
	 * gives runner coordinates
	 * @return
	 */
	public String currentPosition () {
		return x+","+y;
	}
	
	/**
	 * runs some meters randomly helped by runner speed 
	 * moves randomly to right or to left
	 */
	public void run () {
		y = y + random.nextInt(MAX_SPEED) + speed;
		x = (random.nextInt(2) == 0)?random.nextInt(x+1):random.nextInt(Math.abs(RunningOfTheBulls.STREET_WIDTH - x)) + x;
		System.out.println("Running: " + toString());
	}
	
	/**
	 * tell us If runners has reached the end
	 */
	public boolean hasFinished () {
		if (y > RunningOfTheBulls.RUNNING_DISTANCE) {
			System.out.println("Is Finished!! -> " + toString());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return runner information.
	 */
	public String toString () {
		return name + " > speed:" + speed + " position: ["+x+","+y+"]"; 
	}
	
}
