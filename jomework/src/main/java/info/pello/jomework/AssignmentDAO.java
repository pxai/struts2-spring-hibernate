package info.pello.jomework;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * DAO for assignment entity using Hibernate
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
@Repository  
public class AssignmentDAO {

	private SessionFactory sessionFactory;

	public AssignmentDAO () { System.out.println("Bean created");}


	/**
	 * gives hibernate3 Session
	 * @return current hibernate Session
	 */
	private Session getSession () {

		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * gets Assignment data from DataBase
	 * @param assignmentId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Assignment getAssignmentsById (long assignmentId) {
	    Assignment assignment = (Assignment) getSession().get(Assignment.class, assignmentId);
	    return assignment;
	} 

	/**
	 * gets all Assignment data from DataBase
	 * @return list of assignments
	 */
	@Transactional(readOnly = true)
	public List<Assignment> getAssignments () {
		List<Assignment> assignments = null;
		try {
			assignments = getSession().createQuery("from Assignment").list();
		} catch (Exception e) {
			System.err.println("Error e: " + e.getMessage() + ":");
			e.printStackTrace(System.out);
		}
	    return assignments;
	} 
	
	/**
	 * creates new Assignment
	 * @param newAssignment
	 * @return
	 */
	@Transactional
	public long create (Assignment newAssignment) {

		//getSession().beginTransaction();
		 
	    Integer id = (Integer) getSession().save(newAssignment);
	    newAssignment.setId(id);
	         
	    //getSession().getTransaction().commit();
	         
		return id;
	}
	
	/**
	 * updates assignment information 
	 * @param assignment
	 * @return affected rows
	 */
	@Transactional
	public int update (Assignment assignment) {
		
		getSession().merge(assignment);
		return 0;
	}
	
	/**
	 * delete assignment  
	 * @param assignmentId
	 * @return affected rows
	 */
	@Transactional
	public int delete (Long assignmentId) {;
	    
		// It's easier to delete using the object.. but
		// just to see how we should delete by id:
	 	Assignment assignmentToDelete = (Assignment) sessionFactory.getCurrentSession().load(Assignment.class,assignmentId);
	 	getSession().delete(assignmentToDelete);
		return 0;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("Session factory is SET!!");
		if (sessionFactory.isClosed()) {System.out.println("Su puta m,adre");}
	}




}
