package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.Tarea;
import com.vaannila.domain.User;

public class TareaDAOImpl implements TareaDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
/*	public void guardarOActualizarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	public Tarea listarTareaPorId(Long id);
	public void eliminarTarea(Long id);
*/
	/**
	 * Used to save or update a user.
	 */
	@Override
	public void guardarOActualizarTarea(Tarea tarea) {
		try {
			session.saveOrUpdate(tarea);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void eliminarTarea(Long id) {
		try {
			Tarea tarea = (Tarea) session.get(Tarea.class, id);
			session.delete(tarea);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tarea> listarTareas(){
		List<Tarea> tareas = null;
		try {
			tareas = session.createQuery("from Tarea").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tareas;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public Tarea listarTareaPorId(Long id) {
		Tarea tarea = null;
		try {
			tarea = (Tarea) session.get(Tarea.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tarea;
	}

}
