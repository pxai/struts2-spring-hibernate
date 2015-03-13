/**
 * 
 */
package info.pello.mvc.controller;


import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Controller class form default action
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
@Controller
public class HelloController {

        
        /**
         * default constructor
         */
        public HelloController () {
                System.err.println("BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default / or /hello request
         * @param model
         * @return the name of the view to show
         * RequestMapping({"/","","/hello",)
         */
        @RequestMapping({"/","","/hello"})
        public String sayHelloPage(Map<String, Object> model) {
                System.err.println("say hello");
                model.put("greet", "Hello World, welcome to my app");
                // We return view name
                return "hello";
        }

        
}
