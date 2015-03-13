package info.pello.servlets.webon.servlets;

import info.pello.servlets.webon.beans.*;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String datasource;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * init
	 * Se ejecuta al poner en marcha el servlet, antes del doPost o doGet
	 * @throws ServletException
	 */
	public void init () throws ServletException {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		// Control de session
		if (null == session.getAttribute("iduser")) {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);			
		}
		
		// Han pulsado el botón de Edit File??
		// Cargamos un formulario con los campos cargados
		if (null != request.getParameter("editfile") && !request.getParameter("idfile").isEmpty()) {
			// TODO Auto-generated method stub
		
			this.getServletContext().getRequestDispatcher("/editfile.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// Control de session
		if (null == session.getAttribute("iduser")) {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);			
		}

		
		// Han pulsado el botón de New File??
		// comprobamos que no nos mandan campos vacios
		if (null != request.getParameter("newfile") && !request.getParameter("name").isEmpty()) {
			// TODO Auto-generated method stub
		
			FileList fileList = new FileList();
			
			int iduser = Integer.parseInt(session.getAttribute("iduser").toString());
			String text = request.getParameter("text");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			int idfather = Integer.parseInt(request.getParameter("idfather").toString());
			int idtype = Integer.parseInt(request.getParameter("idtype").toString());
		
			fileList.createFile(idfather, iduser, name, desc, text, idtype);
		}
		
		// Han pulsado el botón de Save File??
		// comprobamos que no nos mandan campos vacios
		if (null != request.getParameter("updatefile") && !request.getParameter("text").isEmpty()) {
			// TODO Auto-generated method stub
		
			int iduser = Integer.parseInt(session.getAttribute("iduser").toString());
			int idfile = Integer.parseInt(request.getParameter("idfile").toString());
			File file = new File(idfile, iduser);
			
			String text = request.getParameter("text");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
		
			file.updateFile(text, name, desc);
			System.out.println("File updated!!");
		}
		
		this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

	}

}
