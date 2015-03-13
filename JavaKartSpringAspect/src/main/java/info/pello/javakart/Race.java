package info.pello.javakart;

import java.util.Vector;

/**
 * 
 * @author Pello Altadill
 * @greetz blue mug
 *
 */
public class Race {
	private String name;
	private Circuit circuit;
	private Vector<Kart> karts = new Vector<Kart>();
	private Vector<Kart> finished = new Vector<Kart>();
	
	/**
	 * default constructor
	 */
	public Race () {
		
	}
	

	/**
	 * makes the karts run
	 */
	public void run () {
		do {
			for (int i = 0; i< karts.size(); i++ ) {
				moveKart(karts.elementAt(i));
				if (isFinished(karts.elementAt(i))) {
					moveToFinished(karts.elementAt(i));
				}
			}
		} while (notAllFinished());
		
	}

	/**
	 * shows race result
	 * @return
	 */
	public String showResult() {
		String result = "Race: " + this.getName() + "\n";
		result += "Circuit: " + circuit.toString() + "\n";
		
		for (int i = 0; i< finished.size(); i++ ) {
			result += (i+1) + ".-" + finished.elementAt(i).toString() + "\n";
		}
		
		return result;
	}


	/**
	 * calculates kart movement
	 * moves the car and then substracts circuit difficulty and kart handle points
	 * @param kart
	 */
	private void moveKart(Kart kart) {
		int movedPositions = 0;
		movedPositions = kart.move() - (circuit.difficulty() - kart.handle());
		kart.setPosition(kart.getPosition() + movedPositions);
	}


	/**
	 * moves kart from racing vector to finished vector
	 * @param kart
	 */
	private void moveToFinished(Kart kart) {
		finished.add(kart);
		karts.removeElement(kart);
	}

	/**
	 * checks if kart has run all the distance
	 * @param kart
	 * @return
	 */
	private boolean isFinished(Kart kart) {
		// TODO Auto-generated method stub
		return kart.getPosition() >= circuit.getDistance();
	}


	/**
	 * checks if everyone has finished the race
	 * @return
	 */
	private boolean notAllFinished() {
		// TODO Auto-generated method stub
		return karts.size() > 0;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Race [name=" + name + ", circuit=" + circuit + ", karts="
				+ karts + "]";
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
	 * @return the circuit
	 */
	public Circuit getCircuit() {
		return circuit;
	}
	/**
	 * @param circuit the circuit to set
	 */
	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	/**
	 * @return the karts
	 */
	public Vector<Kart> getKarts() {
		return karts;
	}
	/**
	 * @param karts the karts to set
	 */
	public void setKarts(Vector<Kart> karts) {
		this.karts = karts;
	}


	/**
	 * @return the finished
	 */
	public Vector<Kart> getFinished() {
		return finished;
	}


	/**
	 * @param finished the finished to set
	 */
	public void setFinished(Vector<Kart> finished) {
		this.finished = finished;
	}
	
	
	
}
