package info.pello.eugene.dao;
/**
 * 
 */


import info.pello.eugene.model.User;

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
public class UserDAO implements UserDAOInterface {

	@Autowired
	 private SessionFactory sessionFactory;
	

	/**
	 * default constructor
	 */
	public UserDAO () {
		
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
	public User selectById(int id) {
		User User = (User) getSession().get(User.class, id);
	    return User;
	}

	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public List<User> selectAll() {
	 
	    List<User> Users = getSession().createQuery("from User").list();
	    return Users;
	}
	
	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public int selectAllCount() {
	    List<User> Users = getSession().createQuery("from User").list();
	    return Users.size();
	}

	/*
	 * inserts a new product in database
	 * retrieves generated id and sets to product instance
	 * @param new product
	 */
	 @Transactional
	public void insert(User User) {
	    Integer id = (Integer) getSession().save(User);
	    User.setId(id);           
	}

	/*
	 * updates product
	 * @param product to update
	 */
	 @Transactional
	public void update(User User) {
		getSession().merge(User);
	}

	/*
	 * delete given product
	 * @param product to delete
	 */
	 @Transactional
	public void delete(User User) {
		getSession().delete(User);
	}

	 @Transactional
	public void saveOrUpdate(User User) {

		getSession().saveOrUpdate(User);
		
	}

	 /**
	  * deletes using id
	  */
	 @Transactional
	public void deleteById(int id) {
		 User User = (User) getSession().load(User.class,id);
		 getSession().delete(User);
	}

	 /**
	  * performs search operation
	  */
	 @Transactional(readOnly = true)
	public List<User> search(String name) {
		   Query query = getSession().createQuery("from User s where s.name like :name");
           query.setParameter("name", "%"+name+"%");
           
           List<User> users = query.list();
		
           return users;
	}

}
