/**
 * 
 */
package info.pello.runningbulls;

import java.util.Random;
import java.util.Vector;

/**
 * Represents the crazy race that takes place in my hometown,
 * where 6 running bulls run through narrow streets crowded
 * with people from all around the world.
 * 
 * @author Pello Altadill
 * @greetz my Blue mug
 */
public class RunningOfTheBulls {
	
	private Vector<Bull> bulls;
	private Vector<Human> humanRunners;
	private Vector<Human> deadHumanCollection;
	private Random random;
	private int runnersOnRace;
	
	// These constants will never change...
	private final static int BULLS_IN_RACE = 6;
	public final static int RUNNING_DISTANCE = 850;
	public final static int STREET_WIDTH = 10;
	
	/**
	 * default constructor
	 */
	public RunningOfTheBulls () {
		init();
	}
	
	/**
	 * init racers, both men and beasts
	 */
	private void init () {
		random = new Random();
		deadHumanCollection = new Vector<Human>();
	}
	
	/**
	 * Here is where insanity is unleashed. The running of the bulls
	 * is but a uncontrolled race where despite of your running skills
	 * you're merged in a random events flow of unpredictable results.
	 * Believe me, don't run.
	 * Race will be considered finished when all the bulls reach the finish line.
	 * When each of them arrives we take them off the bulls Vector.
	 */
	public void makeThemRun () {
		do {
			// We make bulls run
			for (int i = 0; i < bulls.size(); i++ ) {
				bulls.get(i).run();
				// remove if finished
				if (bulls.get(i).hasFinished()) {
					bulls.remove(i);
				}
			}
			
			// We make humans run for their lives
			for (int i = 0; i < humanRunners.size(); i++ ) {
				humanRunners.get(i).run();
				if (isCaughtByBull(humanRunners.get(i))) {
					
					deadHumanCollection.add(humanRunners.get(i));
					humanRunners.remove(i);
					continue;
				}
				
				// remove if finished
				if (humanRunners.get(i).hasFinished()) {
					humanRunners.remove(i);
				}
			}
			
		} while (!bulls.isEmpty());
		
		
	}
	
	
	/**
	 * Tells us if human runner is caught by a bull
	 * We consider that first if they are in the same coordinates
	 * and a random value between 0 and 1.
	 * @return
	 */
	private boolean isCaughtByBull (Human human) {
		for (int i = 0; i < bulls.size(); i++ ) {
			if (bulls.get(i).currentPosition().equals(human.currentPosition())) {
				System.out.println("Danger, " + human.toString() + " share same position with " + bulls.get(i).toString());
				// caught or not?
				if (random.nextInt(2) == 0) { return true; }
			}
		}
		
		return false;
	}
	
	/**
	 * gives a report of Human caught by bulls
	 * @return
	 */
	public String deadReport () {
		String report = "-- Wounded Humans Report --\n";
		for (Human human : deadHumanCollection) {
			report += human.toString() + "\n";
		}
			
		report += "TOTAL: " + deadHumanCollection.size() + "\n";
		return report;
	}

	/**
	 * @return the bulls
	 */
	public Vector<Bull> getBulls() {
		return bulls;
	}

	/**
	 * @param bulls the bulls to set
	 */
	public void setBulls(Vector<Bull> bulls) {
		this.bulls = bulls;
	}

	/**
	 * @return the humanRunners
	 */
	public Vector<Human> getHumanRunners() {
		return humanRunners;
	}

	/**
	 * @param humanRunners the humanRunners to set
	 */
	public void setHumanRunners(Vector<Human> humanRunners) {
		this.humanRunners = humanRunners;
	}
}
