/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of roleDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class RoleDAO implements RoleDAOInterface {

    private Session session;
    
    /**
     * default constructor, inits hibernate session
     */
	public RoleDAO () {
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
	 * selects one role by Id
	 * @param id
	 * @return Role
	 */
	public Role selectById(long id) {
	 
	    Role role = (Role) session.get(Role.class, id);

	    return role;
	}

	/*
	 * retrieves all roles from db
	 * @return List of roles
	 */
	public List<Role> selectAll() {
 
	    List<Role> roles = session.createQuery("from Role").list();

	    return roles;
	}

	/*
	 * inserts a new role in database
	 * retrieves generated id and sets to role instance
	 * @param new role
	 */
	public void insert(Role role) {

	    session.beginTransaction();
	 
	    Long id = (Long) session.save(role);
	    role.setId(id);
	         
	    session.getTransaction().commit();

	}

	/*
	 * updates role
	 * @param role to update
	 */
	public void update(Role role) {
		 
		    session.beginTransaction();
		 
		    session.merge(role);
		 
		    session.getTransaction().commit();
		 
	}

	/*
	 * delete given role
	 * @param role to delete
	 */
	public void delete(Role role) {
	    
	    session.beginTransaction();
	    
	    session.delete(role);
	 
	    session.getTransaction().commit();

	}

}
