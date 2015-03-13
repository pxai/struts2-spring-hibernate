/**
 * 
 */
package info.pello.spring.football;

/**
 * Represents a football player
 * @author Pello Xabie Altadill Izura
 * @greetz Old Sadar
 */
public class Home {
  private String name;
  private int capacity;
  
  /**
   * default constructor
   */
  public Home () {
	  
  }
  
	/**
	 * @param name
	 * @param capacity
	 */
	public Home(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Home [name=" + name + ", capacity=" + capacity + "]";
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
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
  
  
}
