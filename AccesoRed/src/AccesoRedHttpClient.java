import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 */

/**
 * @author pello_altadill
 *
 */
public class AccesoRedHttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String direccion = "http://www.google.com";
		HttpGet peticion = new HttpGet(direccion);
		HttpClient clienteHttp = new DefaultHttpClient();
		try {
			ResponseHandler<String> respuesta =
					new BasicResponseHandler();
			// Importar external jar httpcore
			String htmlRecibido 
					= clienteHttp.execute(peticion, respuesta);
			//escupo el resultado
			System.out.println("Recibido: " + htmlRecibido);
			
			
			
		} catch (Exception ex) {
			System.err.println("ERROR DESCONOCIDO 0x5475h");
		}

	}

}
