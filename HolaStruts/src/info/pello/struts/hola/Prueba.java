
package info.pello.struts.hola;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Pello Altadill
 *
 */
public class Prueba extends ActionSupport {
	
    private String nombre;
    private int id;
    private String saludo;
    
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

	@Override
    public String execute()
    {
    	saludo = nombre + " y " + id;
    	System.out.println("Estoy enm exevute");
        
        return SUCCESS;
    }
    
    /**
     * getNombre
     * @return String
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * getNombre
     */
    public void setNombre(String nom)
    {
        nombre = nom;
    }
}