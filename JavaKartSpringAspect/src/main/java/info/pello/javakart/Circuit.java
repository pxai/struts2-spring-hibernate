package info.pello.javakart;

import java.util.Random;

/**
 * Represents a circuit
 * @author Pello Altadill
 * @greetz for the blue mug
 *
 */
public class Circuit {
	
	private String name;
	private int distance;
	
	/**
	 * default constructor
	 */
	public Circuit () {}
	
	/**
	 * @param name
	 * @param distance
	 */
	public Circuit(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	/**
	 * returns random difficulty for karts
	 * @return
	 */
	public int difficulty() {
		 Random random= new Random();
		 
		 // just in 33% of the cases
		 if (random.nextInt(3) == 0) {
			 return random.nextInt(5);
		 } else {
			 return 0;			 
		 }
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circuit [name=" + name + ", position=" + distance + "]";
	}


}
