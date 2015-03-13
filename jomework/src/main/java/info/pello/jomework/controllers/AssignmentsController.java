/**
 * 
 */
package info.pello.jomework.controllers;

import info.pello.jomework.Assignment;
import info.pello.jomework.AssignmentDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller to show the assignments page
 * @author Pello Xabier Altadill Izura	
 * @greetz 4 u as always
 */
@Controller
public class AssignmentsController {
	private AssignmentDAO assignmentDAO;
	
	/**
	 * constructor with autowired parameter
	 * Spring will inject this
	 * @param assignmentDAO
	 */
	@Autowired
	public AssignmentsController (AssignmentDAO assignmentDAO) {
		this.assignmentDAO = assignmentDAO;
	}
	
	/**
	 * handles default / or /hello request
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/assignments","/assignments/show"})
	 */
	@RequestMapping({"/assignments","/assignments/show"})
	public String showAssignments(Map<String, Object> model) {
		if (null == this.assignmentDAO) {		System.out.println("Hutsa dek");}
		List<Assignment> assignments = this.assignmentDAO.getAssignments();
		model.put("assignments", assignments);

		// We return view name
		return "assignments";
	}


}
