/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of insuranceDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class InsuranceDAO implements InsuranceDAOInterface {

	/* 
	 * selects one insurance by Id
	 * @param id
	 * @return Insurance
	 */
	public Insurance selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Insurance insurance = (Insurance) session.get(Insurance.class, id);
	    session.close();
	    return insurance;
	}

	/*
	 * retrieves all insurances from db
	 * @return List of insurances
	 */
	public List<Insurance> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Insurance> insurances = session.createQuery("from Insurance").list();
	    session.close();
	    return insurances;
	}

	/*
	 * inserts a new insurance in database
	 * insurance must come with the idcar set 
	 * @param new insurance
	 */
	public void insert(Insurance insurance) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.save(insurance);     
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates insurance
	 * @param insurance to update
	 */
	public void update(Insurance insurance) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(insurance);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * delete given insurance
	 * @param insurance to delete
	 */
	public void delete(Insurance insurance) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(insurance);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
