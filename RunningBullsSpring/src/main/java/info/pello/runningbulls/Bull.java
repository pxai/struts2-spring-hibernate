/**
 * 
 */
package info.pello.runningbulls;

/**
 * Represents a bull
 * @author Pello Altadill
 * @greetz Islero
 */
public class Bull extends Runner {
	private int weight;
	
	/**
	 * default constructor
	 */
	public Bull () {
		super();
	}
	
	/**
	 * constructor for bull, almost the same as runner
	 * but we add weight attribute
	 * @param name
	 * @param weight
	 * @param speed
	 */
	public Bull(String name, int weight, int speed) {
		// TODO Auto-generated constructor stub
		super(name,speed);
		this.weight= weight;
		System.out.println("Bull created " + toString());
	}
	
	@Override
	public String toString () {
		return "Bull. Weight: "+ weight + "." + super.toString();
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
