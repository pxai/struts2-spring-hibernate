
package info.pello.servlets.webon.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;



public class User {

	private String login;
	private String password;
	private String email;
	private int idhome;
	private int id;

	
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
	 * checkLogin
	 * Comprueba si un login es correcto o no
	 * @return
	 */
	public boolean checkLogin ()  {
		boolean result = false;
		
		try {
			Connection conn = DSConnection.getConnection();
			String sentencia = "select distinct users.*, file.id as idhome from users inner join file on file.iduser=users.id where login='"+login+"' and password=sha1('"+password+"') and file.idfather=0 and file.idtype=1";
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			if (rs.next()) {
				this.id = rs.getInt("id");
				this.idhome = rs.getInt("idhome");
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
			Connection conn = DSConnection.getConnection();
			String sentencia = "select * from users where login='"+login+"' or email='"+email+"'";
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			if (rs.next()) {
				this.id = rs.getInt("id");
				this.email = rs.getString("email");
				this.setIdhome(rs.getInt("idhome"));
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
			Connection conn = DSConnection.getConnection();
			String sql = "insert into users (login, password, email) values ('"+login+"',sha1('"+password+"'),'"+email+"')";
			Statement statement = conn.createStatement();
			
			resultado = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			
			// Si se ha creado bien, retornamos la
			// clave recién generada
			if (resultado>0 && rs.next()) {
				resultado = rs.getInt("GENERATED_KEY");
				setId(resultado);
			}
			 
			conn.close();
		
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * setHomeDir
	 * Una vez creado un usuario, establecemos su dir de inicio
	 * @return int
	 */
	public int setHomeDir (int idhome)  {
		int resultado = 0;
		
		try {
			Connection conn = DSConnection.getConnection();
			String sql = "update users set idhome="+idhome+" where id="+id;
			Statement statement = conn.createStatement();
			
			resultado = statement.executeUpdate(sql);
			
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



	/**
	 * @return the idhome
	 */
	public int getIdhome() {
		return idhome;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setIdhome(int idHome) {
		this.id = idHome;
	}
	
}
