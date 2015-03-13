package org.cuatrovientos.battlefield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * @author Pello Altadill
 * 
 *
 */
public class Battlefield {
	private String name;
	

	@Autowired
    @Qualifier("macedonian")
	private Squad squad1;

	@Autowired
    @Qualifier("persian")
	private Squad squad2;
	
	/**
	 * default constructor
	 */
	public Battlefield () {
		
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
	 * @return the squad1
	 */
	public Squad getSquad1() {
		return squad1;
	}

	/**
	 * @param squad1 the squad1 to set
	 */
	public void setSquad1(Squad squad1) {
		this.squad1 = squad1;
	}

	/**
	 * @return the squad2
	 */
	public Squad getSquad2() {
		return squad2;
	}

	/**
	 * @param squad2 the squad2 to set
	 */
	public void setSquad2(Squad squad2) {
		this.squad2 = squad2;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Battlefield [name=" + name + ", squad1=" + squad1 + ", squad2="
				+ squad2 + "]";
	}



	
	
}