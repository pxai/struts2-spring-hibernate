package info.pello.servlets.qtrwitter.servlets;

import info.pello.servlets.qtrwitter.beans.User;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeeTuits
 */
public class SeeTuits extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String datasource;    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeTuits() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		// Control de session
		if (null == session.getAttribute("iduser")) {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		String login = request.getParameter("u");
		User user = new User(login,"", "");
		user.setDatasource(datasource);
		

			if (user.checkExists()) {
				this.getServletContext().getRequestDispatcher("/tuits.jsp").forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
