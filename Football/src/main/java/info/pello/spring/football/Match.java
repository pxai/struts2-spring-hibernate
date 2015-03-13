/**
 * 
 */
package info.pello.spring.football;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Represents a football match between two teams
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
public class Match {
	
	@Autowired
	@Qualifier("osasuna")
	private Team homeTeam;

	@Autowired
	@Qualifier("erreala")
	private Team visitorTeam;
	
	@Autowired
	@Qualifier("undiano")
	private Referee referee;
	
	@Autowired
	private Home stadium; // There is only one Home in xml file. Spring
						  // will inject that.
	
	private Date date;
	private int homeGoal;
	private int visitorGoal;
	
	/**
	 * default constructor
	 */
	public Match () {
		
	}
	
	/**
	 * gives result of the match
	 * @return
	 */
	public String outcome() {
		// TODO Auto-generated method stub
		return homeTeam.getName() + " " + homeGoal + " - " +
			   visitorTeam.getName() + " " + visitorGoal;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Match [homeTeam=" + homeTeam.toString() + "\n, visitorTeam=" + visitorTeam.toString() + "\n, referee=" 
				+ referee.toString() + "\n, stadium=" + stadium.toString() + "\n, date="
				+ date + ", homeGoal=" + homeGoal + ", visitorGoal="
				+ visitorGoal + "]";
	}

	/**
	 * @return the homeTeam
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	/**
	 * @return the visitorTeam
	 */
	public Team getVisitorTeam() {
		return visitorTeam;
	}

	/**
	 * @param visitorTeam the visitorTeam to set
	 */
	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}

	/**
	 * @return the referee
	 */
	public Referee getReferee() {
		return referee;
	}

	/**
	 * @param referee the referee to set
	 */
	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	/**
	 * @return the stadium
	 */
	public Home getStadium() {
		return stadium;
	}

	/**
	 * @param stadium the stadium to set
	 */
	public void setStadium(Home stadium) {
		this.stadium = stadium;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the homeGoal
	 */
	public int getHomeGoal() {
		return homeGoal;
	}

	/**
	 * @param homeGoal the homeGoal to set
	 */
	public void setHomeGoal(int homeGoal) {
		this.homeGoal = homeGoal;
	}

	/**
	 * @return the visitorGoal
	 */
	public int getVisitorGoal() {
		return visitorGoal;
	}

	/**
	 * @param visitorGoal the visitorGoal to set
	 */
	public void setVisitorGoal(int visitorGoal) {
		this.visitorGoal = visitorGoal;
	}	
	
}
