package info.pello.struts2;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class EquipoDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	

	/**
	 * Used to save or update a user.
	 */
	public void guardarOActualizarEquipo(Equipo equipo) {
		try {
			session.saveOrUpdate(equipo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	public void eliminarEquipo(Long id) {
		try {
			Equipo equipo = (Equipo) session.get(Equipo.class, id);
			session.delete(equipo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	public List<Equipo> listarEquipos(){
		List<Equipo> equipos = null;
		try {
			equipos = session.createQuery("from Equipo").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipos;
	}

	/**
	 * Used to list a single user by Id.
	 */
	public Equipo listarEquipoPorId(Long id) {
		Equipo equipo = null;
		try {
			equipo = (Equipo) session.get(Equipo.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipo;
	}

}
