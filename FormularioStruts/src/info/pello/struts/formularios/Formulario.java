/**
 * 
 */
package info.pello.struts.formularios;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Pello Altadill
 *
 */
public class Formulario extends ActionSupport {
	
    private String nombre;
    private String password;
    private String descripcion;
    private String sexo;
    private int oculto;
    private String hobbies[];
    private int estado;
    private String equipos[];    
    private String resultado;
    
    @Override
    public String execute()
    {
    	// pegamos los contenidos
    	resultado = nombre + " : " + password + " : " + descripcion + " : " + oculto + ": ";
    	
    	for (int i = 0;i<hobbies.length;i++) {
    		resultado += " hobbie elegido: " + hobbies[i];
    	}

    	resultado += sexo + " : " + estado + " : ";

    	for (int i = 0;i<equipos.length;i++) {
    		resultado += " equipos elegido: " + equipos[i];
    	}

        return SUCCESS;
    }
    
    @Override
	public void validate(){
		
		if ( nombre.length() == 0 ){	

			addFieldError( "nombre", "Mete algo en el nombre" );
			
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
     * getNombre
     * @return String
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * setNombre
     * @param String
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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
    
    /**
     * getDescripcion
     * @return String
     */
    public String getDescripcion ()
    {
        return descripcion;
    }
    
    /**
     * setDescripcion
     * @param String
     */
    public void setDescripcion (String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * getOculto
     * @return int
     */
    public int getOculto()
    {
        return oculto;
    }
    
    /**
     * setOculto
     * @param int oculto
     */
    public void setOculto(int oculto)
    {
        this.oculto = oculto;
    }
    
    
    /**
     * getSexo
     * @return String
     */
    public String getSexo()
    {
        return sexo;
    }
    
    /**
     * setSexo
     * @param String
     */
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }
    
    /**
     * getHobbies
     * @return String
     */
    public String[] getHobbies()
    {
        return hobbies;
    }
    
    /**
     * setHobbies
     * @param String[]
     */
    public void setHobbies(String hobbies[])
    {
        this.hobbies = hobbies;
    }
    
    /**
     * getEstado
     * @return int
     */
    public int getEstado()
    {
        return estado;
    }
    
    /**
     * setEstado
     * @param int estado
     */
    public void setEstado(int estado)
    {
        this.estado = estado;
    }
    
    /**
     * getEquipos
     * @return String
     */
    public String[] getEquipos()
    {
        return equipos;
    }
    
    /**
     * setEquipos
     * @param String[]
     */
    public void setEquipos (String equipos[])
    {
        this.equipos = equipos;
    }
}