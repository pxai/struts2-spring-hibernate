/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of userDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class UserDAO implements UserDAOInterface {

    private Session session;
    
	public UserDAO () {
		session = HibernateSession.getSession();
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/* 
	 * selects one user by Id
	 * @param id
	 * @return User
	 */
	public User selectById(long id) {
	    User user = (User) session.get(User.class, id);

	    return user;
	}

	/*
	 * retrieves all users from db
	 * @return List of users
	 */
	public List<User> selectAll() {
	    List<User> users = session.createQuery("from User").list();

	    return users;
	}

	/*
	 * inserts a new user in database
	 * retrieves generated id and sets to user instance
	 * @param new user
	 */
	public void insert(User user) {
	    session.beginTransaction();
	 
	    Long id = (Long) session.save(user);
	    user.setId(id);
	         
	    session.getTransaction().commit();
	         

	}

	/*
	 * updates user
	 * @param user to update
	 */
	public void update(User user) {
		 
		    session.beginTransaction();
		 
		    session.merge(user);
		 
		    session.getTransaction().commit();
		 
	}

	/*
	 * delete given user
	 * @param user to delete
	 */
	public void delete(User user) {
	    
	    session.beginTransaction();
	    
	    session.delete(user);
	 
	    session.getTransaction().commit();

	}

}
