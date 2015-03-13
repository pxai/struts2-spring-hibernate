/**
 * 
 */
package info.pello.struts.formularios;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Pello Altadill
 *
 */
public class Login extends ActionSupport {
	
    private String login;
    private String password;
    private String resultado;
    
    @Override
    public String execute()
    {   
    	resultado = login + " : " + password;
    	
        return SUCCESS;
    }
    
    /**
    * validate
    * se invoca de forma automática
    * en caso de haber error no entrará
    * en execute y retornará un resultado tipo input
    * el cual hay que tratar en el mapa de acciones struts.xml
    */
    @Override
	public void validate(){
		
		if ( login.length() == 0 ){	

			addFieldError( "login", "Mete algo en el login" );
			
		}
		
				
		if ( password.length() == 0 ){	

			addFieldError( "password", "Mete algo en el password" );
			
		}
		
		
		
	}
	
    /**
     * getResultado
     * @return String
     */
    public String getResultado()
    {
        return resultado;
    }
    
    /**
     * getLogin
     * @return String
     */
    public String getLogin()
    {
        return login;
    }
    
    /**
     * setLogin
     * @param String
     */
    public void setLogin(String login)
    {
        this.login = login;
    }

    /**
     * getPassword
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * setPassword
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

}