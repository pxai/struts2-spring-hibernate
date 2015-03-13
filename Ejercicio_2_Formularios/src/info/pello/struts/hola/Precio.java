package info.pello.struts.hola;




import com.opensymphony.xwork2.ActionSupport;

/**
 * Formulario
 * Formulario que hace uso de la internacionalización
 * @author Pello Altadill
 * 
 */
public class Precio extends ActionSupport {


	private float iva;
	private float precio;
	private float calcular;

	
	@Override
	public String execute () {
		
		calcular = (iva/100 ) * (precio);
		return SUCCESS;
	}
	
	
	
	public float getCalcular(){
		return calcular ;
	}



	



	/**
	 * @param iva the iva to set
	 */
	public void setIva(float iva) {
		this.iva = iva;
	}



	
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

	

}
