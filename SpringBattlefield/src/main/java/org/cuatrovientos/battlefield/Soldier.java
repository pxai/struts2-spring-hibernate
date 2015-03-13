package org.cuatrovientos.battlefield;

/**
 * Represents a soldier
 * @author Pello Altadill
 * 
 *
 */
public class Soldier {
	private String name;
	private int attack;
	
	/**
	 * Default constructor
	 */
	public Soldier () {
		
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
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Soldier [name=" + name + ", attack=" + attack + "]";
	}
	
	

}
