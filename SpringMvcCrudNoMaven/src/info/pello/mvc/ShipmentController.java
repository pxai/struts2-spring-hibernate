/**
 * 
 */
package info.pello.mvc;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
    private ShipmentDAOInterface shipmentDAO;
    
        /**
         * default constructor
         */
        public ShipmentController () {
                System.err.println("Shipment BEAN instantiated");
                
        }
        
        
        
        /**
         * handles default /shipment or /shipment/list request
         * @param model
         * @return the name of the view to show
         *  @RequestMapping({"/shipment","/shipment/list"})
         */
        @RequestMapping({"/shipment","*","/shipment/list"})
        public ModelAndView shipmentDefault() {
                System.err.println("Shipment controller> default");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<Shipment> shipmentList = shipmentDAO.selectAll();
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
                System.err.println("Shipment controller> search");
 
                Map<String, Object> model = new HashMap<String, Object>();

                List<Shipment> shipmentList = shipmentDAO.search(description);
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
                System.err.println("Shipment controller> delete " + id);

                shipmentDAO.deleteById(id);
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
                System.err.println("Shipment controller> new shipment ");
                Shipment shipment = new Shipment();
                //shipment.setShipmentDate(new java.sql.Date());
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
        public String newShipment(@ModelAttribute("shipment") Shipment shipment, BindingResult result) {
                System.out.println("Shipment controller> new shipment " + shipment.toString());
                shipmentDAO.insert(shipment);
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
                System.err.println("Shipment controller> detail " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                Shipment shipment = shipmentDAO.selectById(id);
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
                System.err.println("Shipment controller> update " + id);
                Map<String,Object> model = new HashMap<String,Object>();
                Shipment shipment = shipmentDAO.selectById(id);
                model.put("shipment", shipment);
               return new ModelAndView("UpdateShipment",model);

        }
        
        /**
         * handles save updateshipment request. In the jsp we are using spring's form:form tags
         * Spring expects a model called by default 'command' or any name
         * we set to it.
         * @return the name of the view to show
         * @RequestMapping({"/shipment/saveUpdate"})
         */
        @RequestMapping(method=RequestMethod.POST,value={"/shipment/saveupdate"})
        public String saveUpdate(@ModelAttribute("shipment") Shipment shipment, BindingResult result) {
                System.out.println("Shipment controller> update shipment " + shipment.toString());
                shipmentDAO.update(shipment);
                return "redirect:/shipment";
        }
}
