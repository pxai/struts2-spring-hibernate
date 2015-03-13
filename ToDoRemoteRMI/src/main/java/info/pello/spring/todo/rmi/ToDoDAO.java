package info.pello.spring.todo.rmi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * DAO for toDo entity using Hibernate
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
@Repository  
public class ToDoDAO {

	private SessionFactory sessionFactory;

	public ToDoDAO () {}


	/**
	 * gives hibernate3 Session
	 * @return current hibernate Session
	 */
	private Session getSession () {

		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * gets ToDo data from DataBase
	 * @param toDoId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ToDo getToDoById (long toDoId) {
	    ToDo toDo = (ToDo) getSession().get(ToDo.class, toDoId);
	    return toDo;
	} 

	/**
	 * gets all ToDo data from DataBase
	 * @return list of toDos
	 */
	@Transactional(readOnly = true)
	public List<ToDo> getToDos () {
		List<ToDo> toDos = null;

	    toDos = getSession().createQuery("from ToDo").list();

	    return toDos;
	} 
	
	/**
	 * creates new ToDo
	 * @param newToDo
	 * @return
	 */
	@Transactional
	public int create (ToDo newToDo) {

		//getSession().beginTransaction();
		 
	    Integer id = (Integer) getSession().save(newToDo);
	    newToDo.setId(id);
	         
	    //getSession().getTransaction().commit();
	         
		return id;
	}
	
	/**
	 * updates toDo information 
	 * @param toDo
	 * @return affected rows
	 */
	@Transactional
	public int update (ToDo toDo) {
		
		getSession().merge(toDo);
		return 0;
	}
	
	/**
	 * delete toDo  
	 * @param toDoId
	 * @return affected rows
	 */
	@Transactional
	public int delete (Integer toDoId) {;
	    
		// It's easier to delete using the object.. but
		// just to see how we should delete by id:
	 	ToDo toDoToDelete = (ToDo) sessionFactory.getCurrentSession().load(ToDo.class,toDoId);
	 	getSession().delete(toDoToDelete);
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
	}




}
