/**
 * 
 */
package info.pello.eugene.controller;


import info.pello.eugene.business.UserAssignmentBO;
import info.pello.eugene.business.UserAssignmentBOInterface;
import info.pello.eugene.dao.UserAssignmentDAOInterface;
import info.pello.eugene.model.UserAssignment;

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
 * Controller class form UserAssignment management
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
@Controller
public class UserAssignmentController {

	// Get log4j logger
	private static final Logger logger = Logger.getLogger(UserAssignmentController.class);

	@Autowired
    private UserAssignmentBOInterface userAssignmentBO;
    
        /**
         * default constructor
         */
        public UserAssignmentController () {
               logger.info("UserAssignment BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default /userAssignment or /userAssignment/list request
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/userAssignment","/userAssignment/list"})
         */
        @RequestMapping({"/userAssignment","/userAssignment/list"})
        public ModelAndView userAssignmentDefault() {
        	logger.info("default");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<UserAssignment> userAssignmentList = userAssignmentBO.selectAll();
                model.put("userAssignments", userAssignmentList );
                return new ModelAndView("UserAssignmentList", model);     
        }

        /**
         * handles /userAssignment/search request, redirected to default page
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/userAssignment/search"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/userAssignment/search"})
        public ModelAndView search(@RequestParam(value="description", defaultValue="", required=true) String description) {
        	logger.info("search");
 
            Map<String, Object> model = new HashMap<String, Object>();

            List<UserAssignment> userAssignmentList = userAssignmentBO.search(description);
            model.put("userAssignments", userAssignmentList );
            
            return new ModelAndView("UserAssignmentList", model);     
        }

        /**
         * handles delete userAssignment, and redirect to userAssignment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/userAssignment","/userAssignment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/userAssignment/delete"})
        public String deleteUserAssignment(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("delete " + id);

            userAssignmentBO.deleteById(id);
            return "redirect:/userAssignment";

        }
        
        /**
         * handles new userAssignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it: in this case "userAssignment"
         * @return the name of the view to show
         * @RequestMapping({"/userAssignment/new"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/userAssignment/new"})
        public ModelAndView newUserAssignment() {
        		logger.info("new userAssignment ");
                UserAssignment userAssignment = new UserAssignment();
               
                return new ModelAndView("NewUserAssignment", "userAssignment", userAssignment);
        }
        
        /**
         * handles new userAssignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/userAssignment/new"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/userAssignment/save"})
        public String newUserAssignment(@Valid UserAssignment userAssignment, BindingResult bindingResult) {
        		logger.info("new userAssignment " + userAssignment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("userAssignment", userAssignment);
        			return "NewUserAssignment";
        		}
        		
        		// If data is ok, insert and go on
                userAssignmentBO.insert(userAssignment);
                return "redirect:/userAssignment";
        }
        
        /**
         * handles delete userAssignment, and redirect to userAssignment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/userAssignment","/userAssignment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/userAssignment/detail"})
        public ModelAndView userAssignmentDetail(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("Detail " + id);
            Map<String,Object> model = new HashMap<String,Object>();
            UserAssignment userAssignment = userAssignmentBO.selectById(id);
            model.put("userAssignment", userAssignment);
            
            return new ModelAndView("UserAssignmentDetail",model);

        }
        
        /**
         * handles userAssignment update, first part: register loaded
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/userAssignment/update"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/userAssignment/update"})
        public ModelAndView update(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("update " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                UserAssignment userAssignment = userAssignmentBO.selectById(id);
                model.put("userAssignment", userAssignment);
               return new ModelAndView("UpdateUserAssignment",model);

        }
        
        /**
         * handles save update userAssignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/userAssignment/saveUpdate"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/userAssignment/saveupdate"})
        public String saveUpdate(@Valid UserAssignment userAssignment, BindingResult bindingResult) {
        		logger.info("update userAssignment " + userAssignment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("userAssignment", userAssignment);
        			return "UpdateUserAssignment";
        		}
        		
                userAssignmentBO.update(userAssignment);
                return "redirect:/userAssignment";
        }
}
