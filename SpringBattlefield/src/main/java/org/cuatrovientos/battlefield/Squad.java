package org.cuatrovientos.battlefield;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Represents a Squad in the battlefield
 * @author Pello Altadill
 * 
 */
public class Squad {
	private String name;
	private Vector<Soldier> soldiers;
	
	@Autowired
    @Qualifier("Dario")
	private Soldier squadLeader;

	@Autowired
    @Qualifier("panzerTank")
	private Tank tank;
	
	
	/**
	 * default constructor
	 */
	public Squad () {
		
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
	 * @return the soldiers
	 */
	public Vector<Soldier> getSoldiers() {
		return soldiers;
	}
	/**
	 * @param soldiers the soldiers to set
	 */
	public void setSoldiers(Vector<Soldier> soldiers) {
		this.soldiers = soldiers;
	}
	/**
	 * @return the squadLeader
	 */
	public Soldier getSquadLeader() {
		return squadLeader;
	}
	/**
	 * @param squadLeader the squadLeader to set
	 */
	public void setSquadLeader(Soldier squadLeader) {
		this.squadLeader = squadLeader;
	}

	/**
	 * @return the tank
	 */
	public Tank getTank() {
		return tank;
	}

	/**
	 * @param tank the tank to set
	 */
	public void setTank(Tank tank) {
		this.tank = tank;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Squad [name=" + name + ", soldiers=" + soldiers
				+ ", squadLeader=" + squadLeader + ", tank=" + tank + "]";
	}



	
	
}
