import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author pello_altadill
 *
 */
public class AccesoRed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	StringBuilder respuesta = new StringBuilder();
    	String direccion = "http://www.as.com";
	    String linea = null;

    	System.out.println("cargando url:" + direccion);
    	
    	
    	try {
    		// Creamos la URL
    		URL url = new URL(direccion);
    		
    		// ¡¡Abrimos la conexión!! será tipo GET
    		HttpURLConnection conexionHTTP
    	                       = (HttpURLConnection) url.openConnection();
    		
    	// Si el código de respuesta HTTP es 200 todo bien
    	if(conexionHTTP.getResponseCode()==HttpURLConnection.HTTP_OK) {
    		// Leemos la respuesta con un BufferedReader
    	    BufferedReader input = new BufferedReader(
    	            new InputStreamReader(conexionHTTP.getInputStream()),
    	            8192);
    	    // Leemos línea a línea y vamos guardando en un String
    	    while ((linea = input.readLine()) != null) {
    	    	respuesta.append(linea);
    	    }
    	    input.close();
    	}
    	
    	// Ponemos el resultado
    	System.out.println(respuesta.toString());
    	
    	} catch (Exception ex) {
        	System.out.println("No se pudo conectar: " + ex.getMessage() );    		
    	}
    	
    	
    	
    	
    	
    

	}

}
