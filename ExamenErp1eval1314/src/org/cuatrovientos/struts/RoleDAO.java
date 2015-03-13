package org.cuatrovientos.struts;
/**
 * 
 */


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * implementation of roleDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class RoleDAO implements RoleDAOInterface {

	private Session session;
	

	/**
	 * default constructor
	 */
	public RoleDAO () {
		session = HibernateSession.getSession();
	}
	
	/* 
	 * selects one role by Id
	 * @param id
	 * @return Customer
	 */
	public Role selectById(int id) {
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
	 
	    Integer id = (Integer) session.save(role);
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

	
	public void saveOrUpdate(User role) {
	    session.beginTransaction();
	    
	    session.saveOrUpdate(role);
	 
	    session.getTransaction().commit();
		
	}

}
