package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.Tipo;


public class TipoDAOImpl implements TipoDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	

	/**
	 * Used to save or update a tipo.
	 */
	@Override
	public void guardarOActualizarTipo(Tipo tipo) {
		try {
			session.saveOrUpdate(tipo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a tipo.
	 */
	@Override
	public void eliminarTipo(Long id) {
		try {
			Tipo tipo = (Tipo) session.get(Tipo.class, id);
			session.delete(tipo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the tipo.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo> listarTipo() {
		List<Tipo> tipos = null;
		try {
			tipos = session.createQuery("from Tipo").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipos;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public Tipo listarTipoPorId(Long id){
		Tipo tipo = null;
		try {
			tipo = (Tipo) session.get(Tipo.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipo;
	}

}
