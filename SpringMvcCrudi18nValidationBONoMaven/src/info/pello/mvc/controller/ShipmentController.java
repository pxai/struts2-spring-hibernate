/**
 * 
 */
package info.pello.mvc.controller;


import info.pello.mvc.business.ShipmentBO;
import info.pello.mvc.business.ShipmentBOInterface;
import info.pello.mvc.dao.ShipmentDAOInterface;
import info.pello.mvc.model.Shipment;

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
 * Controller class form Shipment management
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 */
@Controller
public class ShipmentController {

	// Get log4j logger
	private static final Logger logger = Logger.getLogger(ShipmentController.class);

	@Autowired
    private ShipmentBOInterface shipmentBO;
    
        /**
         * default constructor
         */
        public ShipmentController () {
               logger.info("Shipment BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default /shipment or /shipment/list request
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment","/shipment/list"})
         */
        @RequestMapping({"/shipment","*","/shipment/list"})
        public ModelAndView shipmentDefault() {
        	logger.info("default");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<Shipment> shipmentList = shipmentBO.selectAll();
                model.put("shipments", shipmentList );
                return new ModelAndView("ShipmentList", model);     
        }

        /**
         * handles /shipment/search request, redirected to default page
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment/search"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/shipment/search"})
        public ModelAndView search(@RequestParam(value="description", defaultValue="", required=true) String description) {
        	logger.info("search");
 
            Map<String, Object> model = new HashMap<String, Object>();

            List<Shipment> shipmentList = shipmentBO.search(description);
            model.put("shipments", shipmentList );
            
            return new ModelAndView("ShipmentList", model);     
        }

        /**
         * handles delete shipment, and redirect to shipment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment","/shipment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/shipment/delete"})
        public String deleteShipment(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("delete " + id);

            shipmentBO.deleteById(id);
            return "redirect:/shipment";

        }
        
        /**
         * handles new shipment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it: in this case "shipment"
         * @return the name of the view to show
         * @RequestMapping({"/shipment/new"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/shipment/new"})
        public ModelAndView newShipment() {
        		logger.info("new shipment ");
                Shipment shipment = new Shipment();
               
                return new ModelAndView("NewShipment", "shipment", shipment);
        }
        
        /**
         * handles new shipment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/shipment/new"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/shipment/save"})
        public String newShipment(@Valid Shipment shipment, BindingResult bindingResult) {
        		logger.info("new shipment " + shipment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("shipment", shipment);
        			return "NewShipment";
        		}
        		
        		// If data is ok, insert and go on
                shipmentBO.insert(shipment);
                return "redirect:/shipment";
        }
        
        /**
         * handles delete shipment, and redirect to shipment default
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment","/shipment/list"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/shipment/detail"})
        public ModelAndView shipmentDetail(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("Detail " + id);
            Map<String,Object> model = new HashMap<String,Object>();
            Shipment shipment = shipmentBO.selectById(id);
            model.put("shipment", shipment);
            
            return new ModelAndView("ShipmentDetail",model);

        }
        
        /**
         * handles shipment update, first part: register loaded
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment/update"})
         */
        @RequestMapping(method=RequestMethod.GET,value={"/shipment/update"})
        public ModelAndView update(@RequestParam(value="id", defaultValue="", required=true) int id) {
        	logger.info("update " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                Shipment shipment = shipmentBO.selectById(id);
                model.put("shipment", shipment);
               return new ModelAndView("UpdateShipment",model);

        }
        
        /**
         * handles save update shipment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/shipment/saveUpdate"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/shipment/saveupdate"})
        public String saveUpdate(@Valid Shipment shipment, BindingResult bindingResult) {
        		logger.info("update shipment " + shipment.toString());
        		
        		// In case of validation errors, go back to form
        		if (bindingResult.hasErrors()) {
        			Map<String, Object> model = new HashMap<String, Object>();
        			model.put("shipment", shipment);
        			return "UpdateShipment";
        		}
        		
                shipmentBO.update(shipment);
                return "redirect:/shipment";
        }
}
