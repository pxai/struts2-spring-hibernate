import java.nio.charset.Charset;
import java.util.Vector;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 * 
 */

/**
 * @author pello_altadill
 *
 */
public class AccesoRedPost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String direccion = "http://localhost/prueba.php";
		HttpPost peticion = null;
		HttpClient clienteHttp = new DefaultHttpClient();
		
		Vector<NameValuePair> parametros = 
				new Vector<NameValuePair>();
		
		ResponseHandler<String> respuesta =
				new BasicResponseHandler();
		
		try {
			// Metemos los parametros
			parametros.add(new BasicNameValuePair("login","falken"));
			parametros.add(new BasicNameValuePair("password","josua"));
			
			direccion += "?" + URLEncodedUtils.format(parametros,Charset.defaultCharset());
			//direccion += "?" + URLEncodedUtils.format(parametros.iterator(), "" );
			
			peticion = new HttpPost(direccion);
			
			String htmlrespuesta = clienteHttp.execute(peticion, respuesta);
			
			if (htmlrespuesta != null ) {
				System.out.println(htmlrespuesta);
			} else {
				System.out.println("No hay respuesta");
			}
			
		} catch (Exception e) {
			System.err.println("OCURRIÓ UN ERROR INESPERADO");
		}
		
	}

}
