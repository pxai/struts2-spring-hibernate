package info.pello.eugene.dao;
/**
 * 
 */


import info.pello.eugene.model.UserAssignment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * implementation of productDAOInterface
 * @author Pello Altadill
 *
 */
public class UserAssignmentDAO implements UserAssignmentDAOInterface {

	@Autowired
	 private SessionFactory sessionFactory;
	

	/**
	 * default constructor
	 */
	public UserAssignmentDAO () {
		
	}
	
	/**
	 * returns Hibernate session
	 * @return
	 */
	 private Session getSession () {
		 return sessionFactory.getCurrentSession();
	 }
	
	/* 
	 * selects one product by Id
	 * @param id
	 * @return product
	 */
	 @Transactional(readOnly = true)
	public UserAssignment selectById(int id) {
		UserAssignment userAssignment = (UserAssignment) getSession().get(UserAssignment.class, id);
	    return userAssignment;
	}

	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public List<UserAssignment> selectAll() {
	 
	    List<UserAssignment> userAssignments = getSession().createQuery("from UserAssignment").list();
	    return userAssignments;
	}
	
	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public int selectAllCount() {
	    List<UserAssignment> userAssignments = getSession().createQuery("from UserAssignment").list();
	    return userAssignments.size();
	}

	/*
	 * inserts a new product in database
	 * retrieves generated id and sets to product instance
	 * @param new product
	 */
	 @Transactional
	public void insert(UserAssignment userAssignment) {
	    Integer id = (Integer) getSession().save(userAssignment);
	    userAssignment.setId(id);           
	}

	/*
	 * updates product
	 * @param product to update
	 */
	 @Transactional
	public void update(UserAssignment userAssignment) {
		getSession().merge(userAssignment);
	}

	/*
	 * delete given product
	 * @param product to delete
	 */
	 @Transactional
	public void delete(UserAssignment userAssignment) {
		getSession().delete(userAssignment);
	}

	 @Transactional
	public void saveOrUpdate(UserAssignment userAssignment) {

		getSession().saveOrUpdate(userAssignment);
		
	}

	 /**
	  * deletes using id
	  */
	 @Transactional
	public void deleteById(int id) {
		 UserAssignment userAssignment = (UserAssignment) getSession().load(UserAssignment.class,id);
		 getSession().delete(userAssignment);
	}

	 /**
	  * performs search operation
	  */
	 @Transactional(readOnly = true)
	public List<UserAssignment> search(String description) {
		   Query query = getSession().createQuery("from UserAssignment s where s.description like :description");
           query.setParameter("description", "%"+description+"%");
           
           List<UserAssignment> userAssignments = query.list();
		
           return userAssignments;
	}

}
