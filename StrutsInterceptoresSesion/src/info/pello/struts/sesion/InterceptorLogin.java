/**
 * 
 */
package info.pello.struts.sesion;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



/**
 * @author luser
 *
 */
public class InterceptorLogin extends AbstractInterceptor {
	
	 @Override
	 public String intercept(final ActionInvocation invocation) throws Exception {
		 // Cogemos la sesión tal y como se explica aquí
		 // http://struts.apache.org/2.x/docs/how-do-we-get-access-to-the-session.html
		 Map<String, Object> session = ActionContext.getContext().getSession();

		 // Recuperamos el id de usuario de la sesión
       Integer idusuario = (Integer)session.get("idusuario");

       System.out.println("InterceptorLogin> Pasamos por el interceptor, idusuario: "  + idusuario);

       // Si es distinto de nulo significa que la sesión está iniciada
       // por tanto permitimos que siga adelante
       if (idusuario != null) {
    	   System.out.println("InterceptorLogin> Ok, sesión OK idusuario: " + idusuario);
           return invocation.invoke();
       }

       Object action = invocation.getAction();


       // AQUÍ ESTÁ EL RECHAZO
       // Si no ha salido antes significa que la La acción SÍ requiere login
       // y si resulta que no estamos en la de Login
       if (!(action instanceof Login)) {
   	   System.out.println("InterceptorLogin> Sesión INCORRECTA!!!");
   	   	// Lo mandamos a la acción login
   	   	
            return "sesionIncorrecta";
       }

       // Este return cubre a la propia acción login
       return invocation.invoke();
   }
}
