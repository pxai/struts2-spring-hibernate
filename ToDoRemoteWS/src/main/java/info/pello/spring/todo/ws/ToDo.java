/**
 * 
 */
package info.pello.spring.todo.ws;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a todo, a Task  to be done
 * @author Pello Xabier Altadill Izura
 *
 */
public class ToDo implements Serializable {
	private int id;
	private String name;
	private String description;
	private Date date;
	private boolean done;
	
	/**
	 * default constructor for hibernate
	 */
	public ToDo () {
		
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param date
	 * @param done
	 */
	public ToDo(int id, String name, String description, Date date, boolean done) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.done = done;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", name=" + name + ", description="
				+ description + ", date=" + date + ", done=" + done + "]";
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
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}
	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	
}
