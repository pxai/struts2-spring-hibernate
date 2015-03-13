package info.pello.servlets.foro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		HttpSession sesion = request.getSession();
		
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Usuario usuario = new Usuario(login,password);
		
		if (usuario.checkLogin()) {
			System.out.println("Login correcto!!" + login);
			sesion.setAttribute("idusuario", usuario.getId());
			this.getServletContext().getNamedDispatcher("Principal").forward(request, response);

		} else {
			request.setAttribute("error", "Login incorrecto");
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
			System.out.println("Login incorrecto: " + login);
		}
	}

}
