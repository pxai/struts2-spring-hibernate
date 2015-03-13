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
public class InterceptorPorMisLogs extends AbstractInterceptor {
	 @Override
	 public String intercept(final ActionInvocation invocation) throws Exception {
	  Map<String,Object> parametros = ActionContext.getContext().getParameters();
	  
	  System.err.println("InterceptorPorMisLogs> Estamos en el interceptor InterceptorPorMisLogs: ");
	  for (String key: parametros.keySet()) {
		  System.err.println("InterceptorPorMisLogs>  " + key + " => " + parametros.get(key));
		  
	  }
	  // Esto hace que se llame
      return invocation.invoke();
  }

}
