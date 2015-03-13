/**
 * 
 */
package info.pello.signup;

/**
 * A dumb service taht we will call from the flow.
 * It could be a DAO or anything else of course...
 * @author Pello Xabier Altadill Izura
 * @greetz whoever reads this
 */
public class ServiceDoSomething {
	
	/**
	 * constructor
	 */
	public ServiceDoSomething() {
		
	}
	
	/**
	 * a method that we will call from within the webflow
	 */
	public void logUser (User user) {
		System.out.println("User is created...");
		System.out.println(user.toString());
	}

}
