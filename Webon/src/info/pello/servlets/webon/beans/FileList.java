package info.pello.servlets.webon.beans;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;

/**
 * FileList
 * Clase para manejar conjuntos de ficheros
 * 
 * @author pello
 *
 */
public class FileList {

	
	/**
	 * TuitList
	 * constructor sin parámetros
	 */
	public FileList () {
		
	}

	/**
	 * getFiles
	 * Pilla los ficheros de determinado usuario en determinado dir
	 * @param int iduser
	 * @param int idfather
	 * @return ArrayList<File>
	 */
	public ArrayList<File> getFiles (int iduser, int idfather)  {
		boolean result = false;
		ArrayList<File> files = new ArrayList<File>();
		File tmpFile;
		
		try {
			Connection conn = DSConnection.getConnection();
			String sql = "select file.*,users.login from file inner join users on file.iduser=users.id where file.iduser=" + iduser + " and idfather=" + idfather + " order by idtype, filedate desc";
		
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				tmpFile = new File(rs.getInt("id"),
									rs.getInt("idfather"),
									rs.getInt("iduser"), 
									rs.getString("login"),
									rs.getString("name"),
									rs.getString("filedate"), 
									rs.getString("description"),
									"", 
									rs.getInt("idtype")
									);
				files.add(tmpFile);
			} 
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return files;
	}
	
	/**
	 * getFile
	 * Toma todos los datos de un fichero
	 * @param int idfile
	 * @return File
	 */
	public File getFile (int idfile, int iduser)  {

		File tmpFile = null;
		
		try {
			Connection conn = DSConnection.getConnection();
			String sql = "select file.*,users.login from file inner join users on file.iduser=users.id where file.iduser=" + iduser + " and file.id="+ idfile;
		
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				tmpFile = new File(rs.getInt("id"),
									rs.getInt("idfather"),
									rs.getInt("iduser"), 
									rs.getString("login"),
									rs.getString("name"),
									rs.getString("filedate"), 
									rs.getString("description"),
									rs.getString("content"), 
									rs.getInt("idtype")
									);
			} 
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return tmpFile;
	}
	
	
	/**
	 * createFile
	 * Crea un fichero
	 * @param int idfather
	 * @param int iduser
	 * @param String newName
	 * @param String newDescription
	 * @param String content
	 * @return int
	 */
	public int createFile (int idfather, int iduser, String newName, String newDescription, String content, int idtype)  {
		int result = 0;
		
		// Si el directorio pertenece al usuario se hace
		if (checkFileOwner(idfather, iduser)) {
			try {
				Connection conn = DSConnection.getConnection();
				String sql = "insert into file (idfather, iduser, name, description, content, idtype) values ("+idfather+","+iduser+",'"+newName+"','"+newDescription+"','"+content+"',"+idtype+")";
			
				Statement statement = conn.createStatement();
				result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = statement.getGeneratedKeys();
				
				// Si se ha creado bien, retornamos la
				// clave recién generada
				if (result>0 && rs.next()) {
					result = rs.getInt("GENERATED_KEY");
				}
	
				conn.close();
			} catch (Exception e) {
				System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
				e.printStackTrace();
			}
		}
			return result;
	}
	
	/**
	 * checkFileOwner
	 * Comprueba que un directorio/fichero pertenece
	 * a determinado usuario
	 * @param int file
	 * @param int iduser
	 * @return boolean
	 */
	public boolean checkFileOwner(int file, int iduser) {
		boolean isOwner = false;
		try {
			Connection conn = DSConnection.getConnection();
			String sql = "select file.id from file where file.iduser=" + iduser + " and file.id=" + file;
		
			System.out.println("Comprobamos propietario: " + sql);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				isOwner = true;
			} 
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return isOwner;
	}
	
	/**
	 * showFiles
	 * shows all files of array in xhtml
	 * @param int iduser
	 * @param int idfather
	 * @return String
	 */
	public String showFiles (int iduser, int idfather) {
		String xhtml = "";
		System.out.println("getting files for " + iduser);
		
		ArrayList<File> files = getFiles(iduser, idfather);
		
		xhtml +="<div class='files'>\n";
		
		for (int i=0;i<files.size();i++) {
			xhtml += files.get(i).showFile();
		}
		
		xhtml += "</div>\n";
		
		return xhtml;
	}

	
}
