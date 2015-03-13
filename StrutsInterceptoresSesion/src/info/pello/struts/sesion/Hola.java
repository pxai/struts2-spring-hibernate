/**
 * 
 */
package info.pello.struts.sesion;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author luser
 *
 */
public class Hola  extends ActionSupport {
	
    private String saludo;
    
    @Override
    public String execute()
    {
    	saludo = "Hola Mundo desde struts2";
        
        return SUCCESS;
    }
    
    /**
     * getSaludo
     * @return String
     */
    public String getSaludo()
    {
        return saludo;
    }
}
