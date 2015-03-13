/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of productTypeDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class ProductTypeDAO implements ProductTypeDAOInterface {

	/* 
	 * selects one productType by Id
	 * @param id
	 * @return ProductType
	 */
	public ProductType selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    ProductType productType = (ProductType) session.get(ProductType.class, id);
	    //session.close();
	    return productType;
	}

	/*
	 * retrieves all productTypes from db
	 * @return List of productTypes
	 */
	public List<ProductType> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<ProductType> productTypes = session.createQuery("from ProductType").list();
	    //session.close();
	    return productTypes;
	}

	/*
	 * inserts a new productType in database
	 * retrieves generated id and sets to productType instance
	 * @param new productType
	 */
	public void insert(ProductType productType) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    Integer id = (Integer) session.save(productType);
	    productType.setId(id);
	         
	    session.getTransaction().commit();
	         
	    //session.close();

	}

	/*
	 * updates productType
	 * @param productType to update
	 */
	public void update(ProductType productType) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(productType);
		 
		    session.getTransaction().commit();
		 
		   // session.close();
	}

	/*
	 * delete given productType
	 * @param productType to delete
	 */
	public void delete(ProductType productType) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(productType);
	 
	    session.getTransaction().commit();
	 
	    //session.close();
	}

}
