/**
 * 
 */
package info.pello.signup.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller to show the home page
 * @author Pello Xabier Altadill Izura	
 * @greetz 4 u as always
 */
@Controller
public class HomeController {
	/**
	 * handles default / or /hello request
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/","/home"})
	 */
	@RequestMapping({"/home","/"})
	public String sayHelloPage(Map<String, Object> model) {
		model.put("message", "Hello World, welcome to SignUp APP");
		
		// We return view name
		return "home";
	}

}