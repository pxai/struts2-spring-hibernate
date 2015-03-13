/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of ProductDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class ProductDAO implements ProductDAOInterface {

	/* 
	 * selects one product by Id
	 * @param id
	 * @return Product
	 */
	public Product selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Product product = (Product) session.get(Product.class, id);
	    //session.close();
	    return product;
	}

	/*
	 * retrieves all products from db
	 * @return List of products
	 */
	public List<Product> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Product> products = session.createQuery("from Product").list();
	    //session.close();
	    return products;
	}

	/*
	 * inserts a new product in database
	 * retrieves generated id and sets to product instance
	 * @param new product
	 */
	public void insert(Product product) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    Integer id = (Integer) session.save(product);
	    product.setId(id);
	         
	    session.getTransaction().commit();
	         
	    //session.close();

	}

	/*
	 * updates product
	 * @param product to update
	 */
	public void update(Product product) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(product);
		 
		    session.getTransaction().commit();
		 
		   // session.close();
	}

	/*
	 * delete given product
	 * @param product to delete
	 */
	public void delete(Product product) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(product);
	 
	    session.getTransaction().commit();
	 
	    //session.close();
	}

}
