/**
 * 
 */
package info.pello.eugene.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Represents an assignment
 * @author Pello Altadill
 *
 */
public class Assignment {
	
	@Min(value=1,message="{assignment.id.min}")
	@Digits(integer=10,message="{assignment.id.error}", fraction = 0)
	private int id;

	@Size(min=2,message="{assignment.name.error}")
	private String name;

	@Size(min=2,message="{assignment.description.error}")
	private String description;

	@Past(message="{assignment.since.error}")
	private java.sql.Timestamp since;

	@Past(message="{assignment.deadline.error}")
	private java.sql.Timestamp deadline;

	@Size(min=2,message="{assignment.test.error}")
	private String test;
	
	@Min(value=1,message="{assignment.idUser.min}")
	@Digits(integer=10,message="{assignment.idUSer.error}", fraction = 0)
	private int idUser;
	
	@Min(value=1,message="{assignment.idGroup.min}")
	@Digits(integer=10,message="{assignment.idGroup.error}", fraction = 0)
	private int idGroup;
	


	@Min(value=0,message="{assignment.attempts.min}")
	@Digits(integer=10,message="{assignment.attempts.error}", fraction = 0)
	private int attempts;
	
	public Assignment () {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param since
	 * @param deadline
	 * @param file
	 * @param idUser
	 * @param idGroup
	 * @param attempts
	 */
	public Assignment(int id, String name, String description, Timestamp since,
			Timestamp deadline, String test, int idUser, int idGroup,
			int attempts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.since = since;
		this.deadline = deadline;
		this.test = test;
		this.idUser = idUser;
		this.idGroup = idGroup;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the deadline
	 */
	public java.sql.Timestamp getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(java.sql.Timestamp deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param file the test to set
	 */
	public void setTest(String test) {
		this.test = test;
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
	 * @return the idGroup
	 */
	public int getIdGroup() {
		return idGroup;
	}

	/**
	 * @param idGroup the idGroup to set
	 */
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
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
		return "Assignment [id=" + id + ", name=" + name + ", description="
				+ description + ", since=" + since + ", deadline=" + deadline
				+ ", test=" + test + ", idUser=" + idUser + ", idGroup="
				+ idGroup + ", attempts=" + attempts + "]";
	}

	
	

}
