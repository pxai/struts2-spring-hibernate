package info.pello.jomework;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * DAO for user entity using Hibernate
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
@Repository  
public class UserDAO {

	private SessionFactory sessionFactory;

	public UserDAO () { System.out.println("Bean created");}


	/**
	 * gives hibernate3 Session
	 * @return current hibernate Session
	 */
	private Session getSession () {

		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * gets User data from DataBase
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public User getUsersById (long userId) {
	    User user = (User) getSession().get(User.class, userId);
	    return user;
	} 

	/**
	 * gets all User data from DataBase
	 * @return list of users
	 */
	@Transactional(readOnly = true)
	public List<User> getUsers () {
		List<User> users = null;
		try {
			users = getSession().createQuery("from User").list();
		} catch (Exception e) {
			System.err.println("Error e: " + e.getMessage() + ":");
			e.printStackTrace(System.out);
		}
	    return users;
	} 
	
	/**
	 * creates new User
	 * @param newUser
	 * @return
	 */
	@Transactional
	public long create (User newUser) {

		//getSession().beginTransaction();
		 
		Long id = (Long) getSession().save(newUser);
	    newUser.setId(id);
	         
	    //getSession().getTransaction().commit();
	         
		return id;
	}
	
	/**
	 * updates user information 
	 * @param user
	 * @return affected rows
	 */
	@Transactional
	public int update (User user) {
		
		getSession().merge(user);
		return 0;
	}
	
	/**
	 * delete user  
	 * @param userId
	 * @return affected rows
	 */
	@Transactional
	public int delete (Long userId) {;
	    
		// It's easier to delete using the object.. but
		// just to see how we should delete by id:
	 	User userToDelete = (User) sessionFactory.getCurrentSession().load(User.class,userId);
	 	getSession().delete(userToDelete);
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
