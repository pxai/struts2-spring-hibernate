package info.pello.maven.hibernate;
/**
 * 
 */


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of sellerDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class SellerDAO implements SellerDAOInterface {

	/* 
	 * selects one customer by Id
	 * @param id
	 * @return Seller
	 */
	public Seller selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Seller seller = (Seller) session.get(Seller.class, id);
	    session.close();
	    return seller;
	}

	/*
	 * retrieves all sellers from db
	 * @return List of sellers
	 */
	public List<Seller> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Seller> sellers = session.createQuery("from Seller").list();
	    session.close();
	    return sellers;
	}

	/*
	 * inserts a new seller in database
	 * retrieves generated id and sets to customer instance
	 * @param new seller
	 */
	public void insert(Seller seller) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    Integer id = (Integer) session.save(seller);
	    seller.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates seller
	 * @param seller to update
	 */
	public void update(Seller seller) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(seller);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * deletes given seller
	 * @param customer to delete
	 */
	public void delete(Seller seller) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(seller);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
