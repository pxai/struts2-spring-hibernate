package info.pello.servlets.webon.servlets;

import info.pello.servlets.webon.beans.User;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String datasource;
    

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * init
	 * Se ejecuta al poner en marcha el servlet, antes del doPost o doGet
	 * @throws ServletException
	 */
	public void init () throws ServletException {
		ServletContext context = this.getServletContext();
		datasource = context.getInitParameter("datasource-name");
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

		HttpSession session = request.getSession();
		
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User user = new User(login,password, "");
		
		// Comprobamos que no van vacíos
		if (login.isEmpty() || password.isEmpty())
		{
			request.setAttribute("error", "Escribe algo");
			this.getServletContext().getRequestDispatcher("/signin.jsp").forward(request, response);
			
		} else {
			if (user.checkLogin()) {
				System.out.println("Login correcto!!" + login);
				session.setAttribute("iduser", user.getId());
				session.setAttribute("login", user.getLogin());
				session.setAttribute("idhome", user.getIdhome());
				this.getServletContext().getNamedDispatcher("Admin").forward(request, response);

			} else {
				request.setAttribute("error", "Login incorrecto");
				this.getServletContext().getRequestDispatcher("/signin.jsp").forward(request, response);
				
				System.out.println("Login incorrecto: " + login);
			}
		}
	}

}
