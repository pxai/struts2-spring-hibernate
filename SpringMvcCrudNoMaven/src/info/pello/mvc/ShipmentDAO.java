package info.pello.mvc;
/**
 * 
 */


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
public class ShipmentDAO implements ShipmentDAOInterface {

	@Autowired
	 private SessionFactory sessionFactory;
	

	/**
	 * default constructor
	 */
	public ShipmentDAO () {
		
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
	public Shipment selectById(int id) {
		Shipment shipment = (Shipment) getSession().get(Shipment.class, id);
	    return shipment;
	}

	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public List<Shipment> selectAll() {
	 
	    List<Shipment> shipments = getSession().createQuery("from Shipment").list();
	    return shipments;
	}
	
	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	 @Transactional(readOnly = true)
	public int selectAllCount() {
	    List<Shipment> shipments = getSession().createQuery("from Shipment").list();
	    return shipments.size();
	}

	/*
	 * inserts a new product in database
	 * retrieves generated id and sets to product instance
	 * @param new product
	 */
	 @Transactional
	public void insert(Shipment shipment) {
	    Integer id = (Integer) getSession().save(shipment);
	    shipment.setId(id);           
	}

	/*
	 * updates product
	 * @param product to update
	 */
	 @Transactional
	public void update(Shipment shipment) {
		getSession().merge(shipment);
	}

	/*
	 * delete given product
	 * @param product to delete
	 */
	 @Transactional
	public void delete(Shipment shipment) {
		getSession().delete(shipment);
	}

	 @Transactional
	public void saveOrUpdate(Shipment shipment) {

		getSession().saveOrUpdate(shipment);
		
	}

	 /**
	  * deletes using id
	  */
	 @Transactional
	public void deleteById(int id) {
		 Shipment shipment = (Shipment) getSession().load(Shipment.class,id);
		 getSession().delete(shipment);
	}

	 /**
	  * performs search operation
	  */
	 @Transactional(readOnly = true)
	public List<Shipment> search(String description) {
		   Query query = getSession().createQuery("from Shipment s where s.description like :description");
           query.setParameter("description", "%"+description+"%");
           
           List<Shipment> shipments = query.list();
		
           return shipments;
	}

}
