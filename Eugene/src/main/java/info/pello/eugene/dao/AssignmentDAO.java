package info.pello.eugene.dao;
/**
 * 
 */


import info.pello.eugene.model.Assignment;

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
public class AssignmentDAO implements AssignmentDAOInterface {

	@Autowired
	 private SessionFactory sessionFactory;
	

	/**
	 * default constructor
	 */
	public AssignmentDAO () {
		
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
	public Assignment selectById(int id) {
		Assignment Assignment = (Assignment) getSession().get(Assignment.class, id);
	    return Assignment;
	}

	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public List<Assignment> selectAll() {
	 
	    List<Assignment> Assignments = getSession().createQuery("from Assignment").list();
	    return Assignments;
	}
	
	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public int selectAllCount() {
	    List<Assignment> Assignments = getSession().createQuery("from Assignment").list();
	    return Assignments.size();
	}

	/*
	 * inserts a new product in database
	 * retrieves generated id and sets to product instance
	 * @param new product
	 */
	 @Transactional
	public void insert(Assignment Assignment) {
	    Integer id = (Integer) getSession().save(Assignment);
	    Assignment.setId(id);           
	}

	/*
	 * updates product
	 * @param product to update
	 */
	 @Transactional
	public void update(Assignment Assignment) {
		getSession().merge(Assignment);
	}

	/*
	 * delete given product
	 * @param product to delete
	 */
	 @Transactional
	public void delete(Assignment Assignment) {
		getSession().delete(Assignment);
	}

	 @Transactional
	public void saveOrUpdate(Assignment Assignment) {

		getSession().saveOrUpdate(Assignment);
		
	}

	 /**
	  * deletes using id
	  */
	 @Transactional
	public void deleteById(int id) {
		 Assignment Assignment = (Assignment) getSession().load(Assignment.class,id);
		 getSession().delete(Assignment);
	}

	 /**
	  * performs search operation
	  */
	 @Transactional(readOnly = true)
	public List<Assignment> search(String description) {
		   Query query = getSession().createQuery("from Assignment s where s.description like :description");
           query.setParameter("description", "%"+description+"%");
           
           List<Assignment> assignments = query.list();
		
           return assignments;
	}

}
