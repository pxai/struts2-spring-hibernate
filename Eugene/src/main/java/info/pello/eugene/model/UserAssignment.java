/**
 * 
 */
package info.pello.eugene.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;

/**
 * Represents an assignment for a user
 * @author Pelo Altadill
 *
 */
public class UserAssignment {
	
	@Min(value=1,message="{userAsignment.id.min}")
	@Digits(integer=10,message="{userAsignment.id.error}", fraction = 0)
	private int id;
	
	@Min(value=1,message="{userAsignment.idUser.min}")
	@Digits(integer=10,message="{userAsignment.idUSer.error}", fraction = 0)
	private int idUser;
	
	@Min(value=1,message="{userAsignment.idAssignment.min}")
	@Digits(integer=10,message="{userAsignment.idAssignment.error}", fraction = 0)
	private int idAssignment;
	
	@Past(message="{userAsignment.shipmentDate.error}")
	private java.sql.Timestamp since;
	
	@Size(min=2,message="{userAsignment.file.error}")
	private String file;

	@Min(value=0,message="{userAsignment.attempts.min}")
	@Digits(integer=10,message="{userAsignment.attempts.error}", fraction = 0)
	private int attempts;
	
	public UserAssignment () {
		
	}

	/**
	 * @param id
	 * @param idUser
	 * @param idAssignment
	 * @param since
	 * @param file
	 * @param attempts
	 */
	public UserAssignment(int id, int idUser, int idAssignment,
			Timestamp since, String file, int attempts) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idAssignment = idAssignment;
		this.since = since;
		this.file = file;
		this.attempts = attempts;
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
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idAssignment
	 */
	public int getIdAssignment() {
		return idAssignment;
	}

	/**
	 * @param idAssignment the idAssignment to set
	 */
	public void setIdAssignment(int idAssignment) {
		this.idAssignment = idAssignment;
	}

	/**
	 * @return the since
	 */
	public java.sql.Timestamp getSince() {
		return since;
	}

	/**
	 * @param since the since to set
	 */
	public void setSince(java.sql.Timestamp since) {
		this.since = since;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the attempts
	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * @param attempts the attempts to set
	 */
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAssignment [id=" + id + ", idUser=" + idUser
				+ ", idAssignment=" + idAssignment + ", since=" + since
				+ ", file=" + file + ", attempts=" + attempts + "]";
	}



}
