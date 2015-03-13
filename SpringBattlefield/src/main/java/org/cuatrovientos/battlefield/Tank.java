package org.cuatrovientos.battlefield;

/**
 * 
 * @author Pello Altadill
 * 
 *
 */
public class Tank {
	private int range;
	private String name;
	
	/**
	 * default constructor
	 */
	public Tank () {
		
	}
	
	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Tank [range=" + range + ", name=" + name + "]";
	}
	
}
