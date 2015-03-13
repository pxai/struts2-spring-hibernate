package info.pello.servlets.webon.beans;

import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class File {
	
	private int id;
	private int idfather;
	private int iduser;
	private String user;
	private String name;
	private String filedate;
	private String description;
	private String content;
	private int idtype;
	public static final int IS_FILE = 2;
	public static final int IS_DIR = 1;
	
	/**
	 * File
	 * Constructor sin parámetros
	 */
	 File () {

	 }

	 
	/**
	 * @param id
	 * @param idfather
	 * @param iduser
	 * @param user
	 * @param name
	 * @param filedate
	 * @param description
	 * @param content
	 * @param idtype
	 */
	public File(int id, int idfather, int iduser, String user, String name,
			String filedate, String description, String content, int idtype) {
		this.id = id;
		this.idfather = idfather;
		this.iduser = iduser;
		this.user = user;
		this.name = name;
		this.filedate = filedate;
		this.description = description;
		this.content = content;
		this.idtype = idtype;
	}
	
	/**
	 * File
	 * Constructor con un solo parámetro
	 * @param int id
	 */
	 public File (int id) {
		 this.id = id;
	 }
	 
	/**
	 * File
	 * Constructor con un solo parámetro
	 * @param int id
		*/
	public File (int id, int iduser) {
		this.id = id;
		this.iduser = iduser;
	}
	 
	 
	 /**
		 * getFileContent
		 * Pilla los ficheros de determinado usuario
		 * @param int idfile
		 * @param int iduser
		 * @return String
		 */
		public String getFileContent ()  {
			String result = "";
			
			try {
				Connection conn = DSConnection.getConnection();
				String sql = "select file.* from file  where file.id=" + id + " file.iduser='" + iduser + "' ";
			
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				if (rs.next()) {
					result = rs.getString("content");
				}

				rs.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
				e.printStackTrace();
			}
			return result;
		}
		

		
		/**
		 * updateFile
		 * Obviamente modifica el fichero
		 * @param String newContent
		 * @param String newName
		 * @param String newDescription
		 * @return int
		 */
		public int updateFile (String newContent, String newName, String newDescription)  {
			int result = 0;
			String 	sql = "update file set content='"+newContent+"',name='"+newName+"', description='"+newDescription+"'  where file.id=" + id + " and  file.iduser=" + iduser ;
			System.out.println(sql);
			try {
				Connection conn = DSConnection.getConnection();
			
				Statement statement = conn.createStatement();
				result = statement.executeUpdate(sql);

				conn.close();
			} catch (Exception e) {
				System.out.println("Excepción: " + e.getMessage() + "Vomitada: \n" );
				e.printStackTrace();
			}
				return result;
		}
		
		
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idfather
	 */
	public int getIdfather() {
		return idfather;
	}


	/**
	 * @param idfather the idfather to set
	 */
	public void setIdfather(int idfather) {
		this.idfather = idfather;
	}


	/**
	 * @return the iduser
	 */
	public int getIduser() {
		return iduser;
	}


	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}


	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the filedate
	 */
	public String getFiledate() {
		return filedate;
	}


	/**
	 * @param filedate the filedate to set
	 */
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}





	/**
	 * @return the idtype
	 */
	public int getIdtype() {
		return idtype;
	}


	/**
	 * @param idtype the idtype to set
	 */
	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}
	
	
	/**
	 * showFile
	 * Returns a file in xhtml
	 * @return String
	 */
	public String showFile () {
		String xhtml = "";
		String img = "file.png";
		String url = "";
		if (idtype==1) {
			img = "Directory.png";
			url = "<a href='/Webon/Admin?dir="+id+"' title='Open dir'>Open</a> | ";
		} 
		
		xhtml += "<div class='file'>\n";
		xhtml += "<div class='text'>"+name+"</div>\n";
		xhtml += "<div class='edit'><img src='./images/"+img+"' alt='Open' title='Open' align='left' />";
		xhtml += url + "<a href='/Webon/Admin?editfile=1&idfile="+ id +"' title='Editar'>Edit</a></div>\n";
		xhtml += "<div class='fileinfo'>"+user+" @ "+filedate+"</div>\n";
		xhtml += "</div>\n";

		return xhtml;
	}
	

	
	
}
