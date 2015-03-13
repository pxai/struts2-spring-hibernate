package info.pello.servlets.qtrwitter.beans;

import java.util.Date;
import java.sql.Timestamp;

public class Tuit {
	
	private int id;
	private int iduser;
	private String user;
	private String text;
	private String tuitdate;
	
	
	/**
	 * Tuit
	 * Constructor
	 * @param id
	 * @param iduser
	 * @param user
	 * @param text
	 * @param tuitdate
	 */
	public Tuit(int id, int iduser, String user, String text, String tuitdate) {
		this.id = id;
		this.iduser = iduser;
		this.user = user;
		this.text = text;
		this.tuitdate = tuitdate;
	}
	
	/**
	 * showTuit
	 * Returns a tuit in xhtml
	 * @return String
	 */
	public String showTuit () {
		String xhtml = "";
		
		xhtml += "<div class='tuit'>\n";
		xhtml += "<div class='text'>"+text+"</div>\n";
		xhtml += "<div class='tuitinfo'>"+user+" @ "+tuitdate+"</div>\n";
		xhtml += "</div>\n";

		return xhtml;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the iduser
	 */
	public int getIduser() {
		return iduser;
	}
	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the tuitdate
	 */
	public String getTuitdate() {
		return tuitdate;
	}
	/**
	 * @param tuitdate the tuitdate to set
	 */
	public void setTuitdate(String tuitdate) {
		this.tuitdate = tuitdate;
	}

	
	
}
