
package info.pello.servlets.qtrwitter.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class User {

	private String login;
	private String password;
	private String email;
	private int id;
	private String datasource;

	
	/**
	 * Usuario
	 * @param String login
	 * @param String password
	 * @param String email
	 */
	public User (String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
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
	 * checkLogin
	 * Comprueba si un login es correcto o no
	 * @return
	 */
	public boolean checkLogin ()  {
		boolean result = false;
		
		try {
			Connection conn = DSConnection.getConnection(datasource);
			String sentencia = "select * from users where login='"+login+"' and password=sha1('"+password+"')";
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			if (rs.next()) {
				this.id = rs.getInt("id");
				System.out.println("Login correcto");
				result = true;
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
	 * checkExists
	 * Comprueba si un login ya existe o no
	 * @return boolean
	 */
	public boolean checkExists ()  {
		boolean result = false;
		
		try {
			Connection conn = DSConnection.getConnection(datasource);
			String sentencia = "select * from users where login='"+login+"' or email='"+email+"'";
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			if (rs.next()) {
				this.id = rs.getInt("id");
				this.email = rs.getString("email");
				result = true;
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
	 * createNew
	 * crea un nuevo usuario, y devuelve el id generado
	 * @return int
	 */
	public int createNew ()  {
		int resultado = 0;
		
		try {
			Connection conn = DSConnection.getConnection(datasource);
			String sentencia = "insert into users (login, password, email) values ('"+login+"',sha1('"+password+"'),'"+email+"')";
			Statement orden = conn.createStatement();
			resultado = orden.executeUpdate(sentencia);
			 
			conn.close();
		
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return resultado;
	}
	
	/**
	 * setters y getters...
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
