
package info.pello.servlets.qtrwitter.servlets;

import info.pello.servlets.qtrwitter.beans.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String datasource;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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

		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");

		// Comprobamos que no van vacíos
		if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
			request.setAttribute("error", "No dejes campos vacíos");
			this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
					
		} else {
			// Comprobamos que los passwords coinciden
			if (password.equals(password2)) {
				User user = new User(login,password, email);
				user.setDatasource(datasource);
				// Comprobamos que el usuario está libre
				if (!user.checkExists()) {
					user.createNew();
					System.out.println("OK, nuevo usuario");
					request.setAttribute("msg", "User created, please sign in");	
					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				} else {
					request.setAttribute("error", "El usuario ya existe");				
					System.out.println("Error, el usuario ya existe");
	
					this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "Los passwords no coinciden");
				System.out.println("Error, los passwords no coinciden");
	
				this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
			}
		}
			
	}// end doPost

}// end class
