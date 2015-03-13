package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.UserDAO;
import com.vaannila.dao.UserDAOImpl;
import com.vaannila.dao.TipoDAO;
import com.vaannila.dao.TipoDAOImpl;
import com.vaannila.domain.Tarea;
import com.vaannila.domain.Tipo;

public class TipoAction extends ActionSupport implements ModelDriven<Tipo> {

	private static final long serialVersionUID = -6659924552566640539L;

	/*	
	 * 	public void guardarOActualizarTipoTarea(TipoTarea tipoTarea);
	public List<TipoTarea> listarTipoTareas();
	public TipoTarea listarTipoTareaPorId(Long id);
	public void eliminarTipoTarea(Long id);
*/
	
	private Tipo tipo = new Tipo();
	private List<Tipo> listaTipos = new ArrayList<Tipo>();
	private TipoDAO tipoDAO = new TipoDAOImpl();
	
	@Override
	public Tipo getModel() {
		return tipo;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		tipoDAO.guardarOActualizarTipo(tipo);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String listar()
	{
		listaTipos = tipoDAO.listarTipo();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tipoDAO.eliminarTipo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tipo = tipoDAO.listarTipoPorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Tipo> getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(List<Tipo> listaTipos) {
		this.listaTipos = listaTipos;
	}

}
