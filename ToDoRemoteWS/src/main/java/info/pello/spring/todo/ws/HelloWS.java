/**
 * 
 */
package info.pello.spring.todo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author root
 *
 */
@Component
@WebService(serviceName="hello")
public class HelloWS {

	@WebMethod
	public String sayHello () {		
		return "Say hello to mi little friend";
	}
}
