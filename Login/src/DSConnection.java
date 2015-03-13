

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DSConnection
 * recupera la conexión con el origen de datos
 * @author root
 *
 */
public class DSConnection {
	/**
	 * getConnection
	 * Inicia la conexi�n con el origen de datos
	 * @return Connection
	 */
	public static Connection getConnection (String connectionName) {
		try {
			InitialContext cxt = new InitialContext();
			
			if ( cxt == null ) {
				   System.out.println("Sin contexto");
				   return null;
			}
			
			System.out.println("Tenemos contexto");

			DataSource ds = (DataSource) cxt.lookup(connectionName);

			if ( ds == null ) {
			   System.out.println("Ds no encontrado");
			   return null;
			}
			
			System.out.println("Tenemos DS");
			
			Connection conn = ds.getConnection();

			return conn;
			
			} catch (Exception e) {
				System.out.println("Excepci�n: " + e.getMessage() + "Vomitada:\n");
				e.printStackTrace();
			}
		
		return null;
	}
}
