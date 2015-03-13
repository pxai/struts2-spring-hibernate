/**
 * 
 */
package info.pello.spring;

/**
 * Simple greet class
 * @author Pello Altadill
 * @greetz Blue Mug
 */
public class Greet {
	private String greeting;

	/**
	 * default constructor
	 */
	public Greet () {
		
	}
	
	/**
	 * @param greeting
	 */
	public Greet(String greeting) {
		this.greeting = greeting;
	}

	/**
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}

	/**
	 * @param greeting the greeting to set
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
}
