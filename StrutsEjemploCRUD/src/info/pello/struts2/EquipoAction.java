package info.pello.struts2;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EquipoAction extends ActionSupport implements ModelDriven<Equipo> {

	private static final long serialVersionUID = -6659354552584240539L;

	
	private Equipo equipo = new Equipo();
	private List<Equipo> listaEquipos = new ArrayList<Equipo>();
	private EquipoDAO equipoDAO = new EquipoDAO();

	
	@Override
	public Equipo getModel() {
		return equipo;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		equipoDAO.guardarOActualizarEquipo(equipo);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String listar()
	{
		listaEquipos = equipoDAO.listarEquipos();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		equipoDAO.eliminarEquipo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		equipo = equipoDAO.listarEquipoPorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	


}
