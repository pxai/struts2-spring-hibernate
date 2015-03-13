/**
 * 
 */
package info.pello.jomework;

import java.sql.Date;



/**
 * Represents assignment entity
 * @author Pello Xabier Altadill Izura
 * @greet to teachers who like them
 */
public class Assignment {
	private int id;
	private String name;
	private String description;
	private Date initDate;
	private Date endDate;
	
	/**
	 * default constructor
	 */
	public Assignment () {
		
	}
	
	/**
	 * @param name
	 * @param description
	 * @param initDate
	 * @param endDate
	 */
	public Assignment(String name, String description, Date initDate,
			Date endDate) {
		this.name = name;
		this.description = description;
		this.initDate = initDate;
		this.endDate = endDate;
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
	 * @return the initDate
	 */
	public Date getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", name=" + name + ", description="
				+ description + ", initDate=" + initDate + ", endDate="
				+ endDate + "]";
	}


	
	
}
