/**
 * 
 */
package info.pello.eugene.controller;



import info.pello.eugene.business.UserBOInterface;
import info.pello.eugene.model.User;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Controller class form User management
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
@Controller
public class UserController {

	// Get log4j logger
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
    private UserBOInterface userBO;
    
        /**
         * default constructor
         */
        public UserController () {
               logger.info("User BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default /user or /user/list request
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/user","/user/list"})
         */
        @RequestMapping({"/user","/user/list"})
        public ModelAndView userDefault() {
        	logger.info("default");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<User> userList = userBO.selectAll();
                model.put("users", userList );
                return new ModelAndView("UserList", model);     
        }

        /**
         * handles /user/search request, redirected to default page
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/user/search"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/user/search"})
        public ModelAndView search(@RequestParam(value="description", defaultValue="", required=true) String description) {
        	logger.info("search");
 
            Map<String, Object> model = new HashMap<String, Object>();

            List<User> userList = userBO.search(description);
            model.put("users", userList );
            
            return new ModelAndView("UserList", model);     
        }

        /**
         * handles delete user, and redirect to user default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/user","/user/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/user/delete"})
        public String deleteUser(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("delete " + id);

            userBO.deleteById(id);
            return "redirect:/user";

        }
        
        /**
         * handles new user request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it: in this case "user"
         * @return the name of the view to show
         * @RequestMapping({"/user/new"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/user/new"})
        public ModelAndView newUser() {
        		logger.info("new user ");
                User user = new User();
               
                return new ModelAndView("NewUser", "user", user);
        }
        
        /**
         * handles new user request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/user/new"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/user/save"})
        public String newUser(@Valid User user, BindingResult bindingResult) {
        		logger.info("new user " + user.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("user", user);
        			return "NewUser";
        		}
        		
        		// If data is ok, insert and go on
                userBO.insert(user);
                return "redirect:/user";
        }
        
        /**
         * handles delete user, and redirect to user default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/user","/user/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/user/detail"})
        public ModelAndView userDetail(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("Detail " + id);
            Map<String,Object> model = new HashMap<String,Object>();
            User user = userBO.selectById(id);
            model.put("user", user);
            
            return new ModelAndView("UserDetail",model);

        }
        
        /**
         * handles user update, first part: register loaded
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/user/update"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/user/update"})
        public ModelAndView update(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("update " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                User user = userBO.selectById(id);
                model.put("user", user);
               return new ModelAndView("UpdateUser",model);

        }
        
        /**
         * handles save update user request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/user/saveUpdate"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/user/saveupdate"})
        public String saveUpdate(@Valid User user, BindingResult bindingResult) {
        		logger.info("update user " + user.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("user", user);
        			return "UpdateUser";
        		}
        		
                userBO.update(user);
                return "redirect:/user";
        }
}
