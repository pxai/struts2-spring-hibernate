package info.pello.struts.hola;

import com.opensymphony.xwork2.ActionSupport;

/**
* @author Pello Altadill
*
*/

public class HolaMundo extends ActionSupport {

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