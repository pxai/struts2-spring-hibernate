package info.pello.servlets.qtrwitter.beans;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;

/**
 * TuitList
 * Clase para manejar conjuntos de tuits
 * 
 * @author pello
 *
 */
public class TuitList {
	
	private String datasource;
	
	/**
	 * TuitList
	 * constructor sin parámetros
	 */
	public TuitList () {
		
	}

	/**
	 * setDatasource
	 * sets datasourcename
	 * @param String datasource
	 */
	public void setDatasource (String datasource) {
		this.datasource = datasource;
	}
	
	
	/**
	 * getMessages
	 * Pilla los tuits de determinado usuario
	 * @param String user
	 * @return ArrayList<Tuit>
	 */
	public ArrayList<Tuit> getTuits (String user)  {
		boolean result = false;
		ArrayList<Tuit> tuits = new ArrayList<Tuit>();
		Tuit tmpTuit;
		
		try {
			Connection conn = DSConnection.getConnection(datasource);
			String sql = "select tuits.*,users.login from tuits inner join users on tuits.iduser=users.id where users.login='" + user + "' order by tuitdate desc";
		//	where tuits.id="+idpadre+" or idpadre=" + idpadre;
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				tmpTuit = new Tuit(rs.getInt("id"),
									rs.getInt("iduser"),
									rs.getString("login"),
									rs.getString("text"),
									rs.getString("tuitdate")
									);
				tuits.add(tmpTuit);
			} 
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return tuits;
	}
	
	
	
	/**
	 * createNew
	 * crea un nuevo tuit y devuelve el id generado
	 * @return int
	 */
	public int createNew ( int iduser, String text)  {
		int result = 0;
		
		try {
			Connection conn = DSConnection.getConnection(datasource);
			String sql = "insert into tuits (iduser, text) values ("+iduser+",'"+text+"')";
			Statement statement = conn.createStatement();
			result = statement.executeUpdate(sql);
			 
			conn.close();
		
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * showTuits
	 * shows all tuits of array in xhtml
	 * @param String user
	 * @return String
	 */
	public String showTuits (String user) {
		String xhtml = "";
		System.out.println("getting tuits for " + user);
		
		ArrayList<Tuit> tuits = getTuits(user);
		
		xhtml +="<div class='tuits'>\n";
		
		for (int i=0;i<tuits.size();i++) {
			xhtml += tuits.get(i).showTuit();
		}
		
		xhtml += "</div>\n";
		
		return xhtml;
	}
	
	/**
	 * setters y getters...
	 * @return
	 */
	



	
	
}
