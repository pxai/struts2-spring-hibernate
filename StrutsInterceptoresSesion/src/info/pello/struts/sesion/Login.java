/**
 * 
 */
package info.pello.struts.sesion;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author luser
 *
 */
public class Login  extends ActionSupport {

		private String saludo;
		private String name;
		private String password;
		


		@Override
	    public String execute()
	    {
			 Map<String, Object> session = ActionContext.getContext().getSession();
			if (name.equals("falken") && password.equals("josua")) {
			 session.put("idusuario", new Integer(666));
			 saludo = "Ok, login correcto, gracias " + name;
			 return SUCCESS;
			} else {
				 session.remove("idusuario");				
				saludo = "Login incorrecto Sr. " + name;
			 return ERROR;
			}
	    }
		
		/**
		 * getSaludo
		 * @return saludo
		 */
	    public String getSaludo() {
			return saludo;
		}

	    /**
	     * setSaludo
	     * @param saludo
	     */
		public void setSaludo(String saludo) {
			this.saludo = saludo;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}


	}


