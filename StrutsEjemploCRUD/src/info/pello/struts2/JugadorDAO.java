package info.pello.struts2;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class JugadorDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	

	/**
	 * Used to save or update a user.
	 */
	public void guardarOActualizarJugador(Jugador jugador) {
		try {
			session.saveOrUpdate(jugador);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	public void eliminarJugador(Long id) {
		try {
			Jugador jugador = (Jugador) session.get(Jugador.class, id);
			session.delete(jugador);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	public List<Jugador> listarJugadores(){
		List<Jugador> jugadores = null;
		try {
			jugadores = session.createQuery("from Jugador").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jugadores;
	}

	/**
	 * Used to list a single user by Id.
	 */
	public Jugador listarJugadorPorId(Long id) {
		Jugador jugador = null;
		try {
			jugador = (Jugador) session.get(Jugador.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jugador;
	}

}
