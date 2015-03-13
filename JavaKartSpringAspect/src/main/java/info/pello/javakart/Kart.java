package info.pello.javakart;

import java.util.Random;

/**
 * @author Pello Altadill
 * @greetz for the blue mug
 */
public  class Kart {
	private String name;
	private int speed;
	private int acceleration;
	private int grip;
	private int position;
	
	/**
	 * @param nombre
	 */
	public Kart() {
		init();
	}


	/**
	 * inicializar
	 * inicializa las variables de velocidad, aceleracion
	 * y agarre con valores aleatorios
	 */
	private void init(){
		Random aleatorio= new Random();
		this.position = 0;
		this.speed=aleatorio.nextInt(18);
		this.acceleration=aleatorio.nextInt(18-this.speed);
		this.grip=aleatorio.nextInt(18-this.speed-this.acceleration);
	}
	/**
	 * mover
	 * devuelve el numero de posiciones que se mueve el coche
	 * @return
	 */
	public int move()
	{
	 int result;
	 Random random= new Random();
	 
	 result=this.speed+this.acceleration+random.nextInt(6);
	return result;
	}
	/*
	 * handle
	 *maniobrar es la suma de agarre y un valor aleatorio
	 */
	public int handle ()
	{
		 int result;
		 Random random= new Random();
	 
		 result=this.grip+random.nextInt(6);
		return result;
	}

	/** getters/setters & toString **/
	@Override
	public String toString() {
		return "Kart [name=" + name + ", speed=" + speed + ", acceleration="
				+ acceleration + ", grip=" + grip + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getAcceleration() {
		return acceleration;
	}


	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}


	public int getGrip() {
		return grip;
	}


	public void setGrip(int grip) {
		this.grip = grip;
	}


	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
}

