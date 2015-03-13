package info.pello.servlets.foro;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;

/**
 * Foro
 * Clase para manejar el foro: nuevas entradas
 * listar, etc...
 * 
 * @author pello
 *
 */
public class Foro {

	
	/**
	 * Foro
	 * constructor sin parámetros
	 */
	public Foro () {

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
			
			Connection conn = ds.getConnection();

			return conn;
			
			} catch (Exception e) {
				System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	/**
	 * getMessages
	 * Pilla los mensajes de determinado hilo
	 * @return
	 */
	public ArrayList<Mensaje> getMessages (int idpadre)  {
		boolean result = false;
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		Mensaje tmpMsg;
		
		try {
			Connection conn = this.getConnection();
			String sentencia = "select entrada.*,usuario.login from entrada inner join usuario on entrada.idusuario=usuario.id where entrada.id="+idpadre+" or idpadre=" + idpadre;
			Statement orden = conn.createStatement();
			ResultSet rs = orden.executeQuery(sentencia);
			while (rs.next()) {
				tmpMsg = new Mensaje(rs.getInt("id"),
									idpadre,
									rs.getInt("idusuario"),
									rs.getString("login"),
									rs.getString("titulo"),
									rs.getString("texto"),
									rs.getString("fecha")
									);
				mensajes.add(tmpMsg);
			} 
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage() + "Vomitada:\n");
			e.printStackTrace();
		}
		return mensajes;
	}
	
	
	
	/**
	 * createNew
	 * crea un nuevo mensaje/hilo y devuelve el id generado
	 * @return int
	 */
	public int createNew ( int idpadre, int idusuario, String titulo, String texto)  {
		int resultado = 0;
		
		try {
			Connection conn = this.getConnection();
			String sentencia = "insert into entrada (idpadre, idusuario, titulo,texto, fecha) values ("+idpadre+","+idusuario+",'"+titulo+"','"+texto+"',datetime())";
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
	



	
	
}
