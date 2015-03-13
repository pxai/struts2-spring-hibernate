package info.pello.servlets.foro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Principal
 */
public class HiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Foro foro;
    
    /**
     * init
     * Al iniciarse el servlet se invoca de forma 
     * automática
     */
    public void init () throws ServletException {
    	foro = new Foro();
    	
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.getServletContext().getRequestDispatcher("/hilo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		int idusuario = Integer.parseInt(sesion.getAttribute("idusuario").toString());
		System.out.println("Id de usuario: " + idusuario);
		if (request.getParameter("idpadre") != null) {
			int idpadre = Integer.parseInt(request.getParameter("idpadre"));
			String titulo = request.getParameter("titulo");
			String texto = request.getParameter("texto");
		
			foro.createNew(idpadre, idusuario, titulo, texto);
		}
		this.getServletContext().getRequestDispatcher("/hilo.jsp").forward(request, response);

	}

}
