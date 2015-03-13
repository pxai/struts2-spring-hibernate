/**
 * 
 */
package info.pello.eugene.controller;


import info.pello.eugene.business.AssignmentBO;
import info.pello.eugene.business.AssignmentBOInterface;
import info.pello.eugene.dao.AssignmentDAOInterface;
import info.pello.eugene.model.Assignment;

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
 * Controller class form Assignment management
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
@Controller
public class AssignmentController {

	// Get log4j logger
	private static final Logger logger = Logger.getLogger(AssignmentController.class);

	@Autowired
    private AssignmentBOInterface AssignmentBO;
    
        /**
         * default constructor
         */
        public AssignmentController () {
               logger.info("Assignment BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default /assignment or /assignment/list request
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/assignment","/assignment/list"})
         */
        @RequestMapping({"/assignment","/assignment/list"})
        public ModelAndView AssignmentDefault() {
        	logger.info("default");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<Assignment> AssignmentList = AssignmentBO.selectAll();
                model.put("Assignments", AssignmentList );
                return new ModelAndView("AssignmentList", model);     
        }

        /**
         * handles /assignment/search request, redirected to default page
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/assignment/search"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/assignment/search"})
        public ModelAndView search(@RequestParam(value="description", defaultValue="", required=true) String description) {
        	logger.info("search");
 
            Map<String, Object> model = new HashMap<String, Object>();

            List<Assignment> AssignmentList = AssignmentBO.search(description);
            model.put("Assignments", AssignmentList );
            
            return new ModelAndView("AssignmentList", model);     
        }

        /**
         * handles delete Assignment, and redirect to Assignment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/assignment","/assignment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/assignment/delete"})
        public String deleteAssignment(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("delete " + id);

            AssignmentBO.deleteById(id);
            return "redirect:/assignment";

        }
        
        /**
         * handles new Assignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it: in this case "Assignment"
         * @return the name of the view to show
         * @RequestMapping({"/assignment/new"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/assignment/new"})
        public ModelAndView newAssignment() {
        		logger.info("new Assignment ");
                Assignment Assignment = new Assignment();
               
                return new ModelAndView("NewAssignment", "Assignment", Assignment);
        }
        
        /**
         * handles new Assignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/assignment/new"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/assignment/save"})
        public String newAssignment(@Valid Assignment Assignment, BindingResult bindingResult) {
        		logger.info("new Assignment " + Assignment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("Assignment", Assignment);
        			return "NewAssignment";
        		}
        		
        		// If data is ok, insert and go on
                AssignmentBO.insert(Assignment);
                return "redirect:/assignment";
        }
        
        /**
         * handles delete Assignment, and redirect to Assignment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/assignment","/assignment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/assignment/detail"})
        public ModelAndView AssignmentDetail(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("Detail " + id);
            Map<String,Object> model = new HashMap<String,Object>();
            Assignment Assignment = AssignmentBO.selectById(id);
            model.put("Assignment", Assignment);
            
            return new ModelAndView("AssignmentDetail",model);

        }
        
        /**
         * handles Assignment update, first part: register loaded
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/assignment/update"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/assignment/update"})
        public ModelAndView update(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("update " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                Assignment Assignment = AssignmentBO.selectById(id);
                model.put("Assignment", Assignment);
               return new ModelAndView("UpdateAssignment",model);

        }
        
        /**
         * handles save update Assignment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/assignment/saveUpdate"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/assignment/saveupdate"})
        public String saveUpdate(@Valid Assignment Assignment, BindingResult bindingResult) {
        		logger.info("update Assignment " + Assignment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("Assignment", Assignment);
        			return "UpdateAssignment";
        		}
        		
                AssignmentBO.update(Assignment);
                return "redirect:/assignment";
        }
}
