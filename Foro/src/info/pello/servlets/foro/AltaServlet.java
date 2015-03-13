package info.pello.servlets.foro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String destino = "";
		
		if (password.equals(password2)) {
			Usuario usuario = new Usuario(login,password);
			if (!usuario.checkExists()) {
				usuario.createNew();
				System.out.println("OK, nuevo usuario");
				this.getServletContext().getNamedDispatcher("Principal").forward(request, response);
			} else {
				request.setAttribute("error", "El usuario ya existe");				
				System.out.println("Error, el usuario ya existe");
				destino = "/alta.jsp";
				this.getServletContext().getRequestDispatcher(destino).forward(request, response);
			}
		} else {
			request.setAttribute("error", "Los passwords no coinciden");
			System.out.println("Error, los passwords no coinciden");
			destino = "/alta.jsp";
			this.getServletContext().getRequestDispatcher(destino).forward(request, response);
		}
		
			
	}

}
