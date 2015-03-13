package info.pello.struts2;

import java.util.Set;


public class Equipo {

	private Long id;
	private String nombre;
    private Set<Jugador> jugadores;
	
    public Equipo () {
    	
    }
    
    public Equipo (Long id, String nombre) {
    	this.id = id;
    	this.nombre = nombre;
    }
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the jugadores
	 */
	public Set<Jugador> getJugadores() {
		return jugadores;
	}
	/**
	 * @param jugadores the jugadores to set
	 */
	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
}
