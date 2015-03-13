import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author pello_altadill
 *
 */
public class AccesoRedJsoupIbex35 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html";
		// importar Document de la librería jsoup
		try {
			
			// recoger la página en un documento
			Document documento = Jsoup.connect(url).get();
			
			// importar Elements de la librería jsoup
			Elements filas = documento.select("TR TD.primera");
			int i = 0;
			for (Element fila : filas) {
				i++;
				Element celda = fila.select("TD.primera > a").first();
				Elements celdavalor = fila.select("TD.primera ~ TD");
				System.out.print("Valor: "+ i +". " + celda.text());
				//System.out.println(": "+ celdavalor.first().text());
				for (Element cel: celdavalor) {
					System.out.println(cel.data());
				}
			}
			
		} catch (IOException e) {
			System.err.println("Cagada " + e.getMessage());
		}
	}

}
