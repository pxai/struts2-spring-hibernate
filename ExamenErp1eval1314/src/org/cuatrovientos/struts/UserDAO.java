package org.cuatrovientos.struts;
/**
 * 
 */



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * implementation of userDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class UserDAO implements UserDAOInterface {

	private Session session;
	

	/**
	 * default constructor
	 */
	public UserDAO () {
		session = HibernateSession.getSession();
	}
	
	/* 
	 * selects one user by Id
	 * @param id
	 * @return Customer
	 */
	public User selectById(int id) {
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
	 
	    Integer id = (Integer) session.save(user);
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
	public void delete(User  user) {
	    
	    session.beginTransaction();
	    
	    session.delete(user);
	 
	    session.getTransaction().commit();
	 
	}

	
	public void saveOrUpdate(User user) {
	    session.beginTransaction();
	    
	    session.saveOrUpdate(user);
	 
	    session.getTransaction().commit();
		
	}

	/**
	 * checks user login/password data
	 * @param login
	 * @param password
	 */
	@Override
	public boolean checkLogin(String login, String password) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User s where s.login = :login and s.password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        
        List<User> users = query.list();
        
        session.close();
		return (null != users && users.size()>0);
	}

	/**
	 * selects users from role specified in param
	 * @param idrole
	 * @return
	 */
	public List<User> selectRoles(int roleid) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User s where s.roleid = :roleid");
        query.setParameter("roleid", roleid);
        
        List<User> users = query.list();
        
        session.close();
	    return users;
	}

}
