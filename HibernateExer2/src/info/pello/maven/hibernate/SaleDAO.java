package info.pello.maven.hibernate;
/**
 * 
 */


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of SaleDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class SaleDAO implements SaleDAOInterface {

	/* 
	 * selects one customer by Id
	 * @param id
	 * @return Sale
	 */
	public Sale selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Sale Sale = (Sale) session.get(Sale.class, id);
	    session.close();
	    return Sale;
	}

	/*
	 * retrieves all Sales from db
	 * @return List of Sales
	 */
	public List<Sale> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Sale> sales = session.createQuery("from Sale").list();
	    session.close();
	    return sales;
	}

	/*
	 * inserts a new Sale in database
	 * retrieves generated id and sets to customer instance
	 * @param new Sale
	 */
	public void insert(Sale sale) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    Integer id = (Integer) session.save(sale);
	    sale.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates Sale
	 * @param Sale to update
	 */
	public void update(Sale sale) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(sale);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * deletes given Sale
	 * @param customer to delete
	 */
	public void delete(Sale sale) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(sale);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
