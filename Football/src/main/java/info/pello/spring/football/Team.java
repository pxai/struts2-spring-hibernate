/**
 * 
 */
package info.pello.spring.football;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Represents a football stadium
 * @author Pello Xabie Altadill Izura
 * @greetz Osasuna
 */
public class Team {
	private String name;
	private Hashtable<Integer,Player> players;
	
	@Autowired
	@Qualifier("sadar")
	private Home homeStadium;
	
	/**
	 * default constructor
	 */
	public Team () {
		
	}
	
	/**
	 * @param name
	 * @param players
	 * @param homeStadium
	 */
	public Team(String name, Hashtable<Integer, Player> players,
			Home homeStadium) {
		super();
		this.name = name;
		this.players = players;
		this.homeStadium = homeStadium;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [name=" + name + ", players=" + players.toString() + ", homeStadium="
				+ homeStadium + "]";
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
	 * @return the players
	 */
	public Hashtable<Integer, Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Hashtable<Integer, Player> players) {
		this.players = players;
	}

	/**
	 * @return the homeStadium
	 */
	public Home getHomeStadium() {
		return homeStadium;
	}

	/**
	 * @param homeStadium the homeStadium to set
	 */
	public void setHomeStadium(Home homeStadium) {
		this.homeStadium = homeStadium;
	}
	
	
}
