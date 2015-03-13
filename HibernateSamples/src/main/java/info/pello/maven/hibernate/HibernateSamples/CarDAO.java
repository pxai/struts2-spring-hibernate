/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of carDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class CarDAO implements CarDAOInterface {

	/* 
	 * selects one car by Id
	 * @param id
	 * @return Car
	 */
	public Car selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Car car = (Car) session.get(Car.class, id);
	    session.close();
	    return car;
	}

	/*
	 * retrieves all cars from db
	 * @return List of cars
	 */
	public List<Car> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Car> cars = session.createQuery("from Car").list();
	    session.close();
	    return cars;
	}

	/*
	 * inserts a new car in database
	 * retrieves generated id and sets to car instance
	 * @param new car
	 */
	public void insert(Car car) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    Integer id = (Integer) session.save(car);
	    car.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates car
	 * @param car to update
	 */
	public void update(Car car) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(car);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * delete given car
	 * @param car to delete
	 */
	public void delete(Car car) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(car);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
