package info.pello.servlets.foro;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.Statement;

import javax.naming.InitialContext;

public class Usuario {

	private String login;
	private String password;
	private int id;
	

	
	/**
	 * Usuario
	 * @param String login
	 * @param String password
	 */
	Usuario (String login, String password) {
		this.login = login;
		this.password = password;
	}

	
	/**
	 * getConnection
	 * Inicia la conexión con el origen de datos
	 * @return Connection
	 */
	private Connection getConnection () {
		try {
			InitialContext cxt = new InitialContext();
			
			if ( cxt == null ) {
				   System.out.println("Sin contexto");
				   return null;
			}
			
			System.out.println("Tenemos contexto");

			DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/foro");

			if ( ds == null ) {
			   System.out.println("Ds no encontrado");
			   return null;
			}
			
			System.out.println("Tenemos DS");
			
			Connection conn = ds.getConnection();

			return conn;
			
			} catch (Exception e) {
				System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	/**
	 * checkLogin
	 * Comprueba si un login es correcto o no
	 * @return
	 */
	public boolean checkLogin ()  {
		boolean result = false;
		
		try {
			Connection conn = this.getConnection();
			String sentencia = "select * from usuario where login='"+login+"' and password='"+password+"'";
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
			Connection conn = this.getConnection();
			String sentencia = "select * from usuario where login='"+login+"'";
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			if (rs.next()) {
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
			Connection conn = this.getConnection();
			String sentencia = "insert into usuario (login, password) values ('"+login+"','"+password+"')";
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
	
	
	
}
