import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author pello_altadill
 *
 */
public class Usuario {

	/**
	 * Usuario
	 * constructor por defecto
	 */
	Usuario () {
		
	}
	
	/**
	 * esLoginCorrecto
	 * Comprueba que el usuario y contraseña
	 * es correcto
	 * @param String username
	 * @param String password
	 * @return boolean
	 */
	public boolean esLoginCorrecto (String username, String password) {
		boolean resultado  = false;
		//Connection conn;
		
		try {
			// Para conectarse a la BBDD
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
			
			// Ahora lo hacemos con nuestra clase
			// que consigue la Connection por JNDI todo pro
			//conn = DSConnection.getConnection("jdbc/miconexion"); 
					
			// Creamos la sentencia para ejecutar ordenes
			Statement stat = conn.createStatement();
			// Definimos un String con la orden SQL
			 String sql = "select * from user where login='"+ username +"' and pass=sha1('"+password+"')";
             // Ejecutamos la SQL en la BBDD
             ResultSet rs = stat.executeQuery(sql);
             
             if (rs.next()){
            	 return true;
             }else{
            	 return false;
             }
             
             
            //Soy un páladin!!!
           
			
		} catch (SQLException sqlex) {
			sqlex.printStackTrace(System.err);
			System.err.println("No conecto jdbc: " + sqlex.getMessage() + ":");
		} catch (Exception ex) {
			System.err.println("No conecto: " + ex.getMessage());
			ex.printStackTrace(System.err);
		}
		
		if (username.equals("falken") 
				&& password.equals("josua")) {
			resultado = true;
		}
		
		return resultado;
	}
	
}
