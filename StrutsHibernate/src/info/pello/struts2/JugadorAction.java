package info.pello.struts2;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class JugadorAction extends ActionSupport implements ModelDriven<Jugador> {

	private static final long serialVersionUID = -6659354552584240539L;

	
	private Jugador jugador = new Jugador();
	private List<Jugador> listaJugadores = new ArrayList<Jugador>();
	private JugadorDAO jugadorDAO = new JugadorDAO();
	//private List<Equipo> equipos;
	private EquipoDAO equipoDAO = new EquipoDAO();
	private String nombre;
	
	@Override
	public Jugador getModel() {
		return jugador;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		jugadorDAO.guardarOActualizarJugador(jugador);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String listar()
	{
		listaJugadores = jugadorDAO.listarJugadores();
		return SUCCESS;
	}
	
	/**
	 * busca jugadores
	 * @return String
	 */
	public String buscar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		listaJugadores = jugadorDAO.buscarJugadores(request.getParameter("nombre"));
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		jugadorDAO.eliminarJugador(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		jugador = jugadorDAO.listarJugadorPorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	
	public List<Equipo> getEquipos() {

		return equipoDAO.listarEquipos();
	}

	/**
	 * @return the equipoDAO
	 */
	public EquipoDAO getEquipoDAO() {
		return equipoDAO;
	}

	/**
	 * @param equipoDAO the equipoDAO to set
	 */
	public void setEquipoDAO(EquipoDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
