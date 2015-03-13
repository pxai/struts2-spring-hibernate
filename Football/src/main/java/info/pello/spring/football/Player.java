/**
 * 
 */
package info.pello.spring.football;

import java.util.Random;

/**
 * Represents a football player
 * @author Pello Xabie Altadill Izura
 * @greetz Jan Urban
 */
public class Player {
	private String name;
	private int number;
	private String position;
	private int kick;
	private int pass;
	private int dodge; // dribbling
    private Random random = new Random();
	
	/**
	 * default constructor
	 */
	public Player () {
		init();
	}
	
	/**
	 * Constructor using some fields
	 * @param name
	 * @param number
	 * @param position
	 */
	public Player (String name, int number, String position) {
		this.name = name;
		this.number = number;
		this.position = position;
	}

	/**
	 * inits player playing atributes
	 */
	private void init () {
		this.kick = random.nextInt(6) + 1;
		this.pass = random.nextInt(6) + 1;
		this.dodge = random.nextInt(6) + 1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", number=" + number + ", position="
				+ position + ", kick=" + kick + ", pass=" + pass + ", dodge="
				+ dodge + ", random=" + random + "]";
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
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the kick
	 */
	public int getKick() {
		return kick;
	}

	/**
	 * @param kick the kick to set
	 */
	public void setKick(int kick) {
		this.kick = kick;
	}

	/**
	 * @return the pass
	 */
	public int getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(int pass) {
		this.pass = pass;
	}

	/**
	 * @return the dodge
	 */
	public int getDodge() {
		return dodge;
	}

	/**
	 * @param dodge the dodge to set
	 */
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	
	
}
