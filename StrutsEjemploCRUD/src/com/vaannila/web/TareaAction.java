package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.TareaDAO;
import com.vaannila.dao.TareaDAOImpl;
import com.vaannila.dao.TipoDAO;
import com.vaannila.dao.TipoDAOImpl;
import com.vaannila.domain.Tarea;
import com.vaannila.domain.Tipo;

public class TareaAction extends ActionSupport implements ModelDriven<Tarea> {

	private static final long serialVersionUID = -6659924552584240539L;

	/*	public void guardarOActualizarTarea(Tarea tarea);
	public List<Tarea> listarTareas();
	public Tarea listarTareaPorId(Long id);
	public void eliminarTarea(Long id);
*/
	
	private Tarea tarea = new Tarea();
	private List<Tarea> listaTareas = new ArrayList<Tarea>();
	private TareaDAO tareaDAO = new TareaDAOImpl();

	
	@Override
	public Tarea getModel() {
		return tarea;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		tareaDAO.guardarOActualizarTarea(tarea);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String listar()
	{
		listaTareas = tareaDAO.listarTareas();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tareaDAO.eliminarTarea(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		tarea = tareaDAO.listarTareaPorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<Tarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}
	


}
