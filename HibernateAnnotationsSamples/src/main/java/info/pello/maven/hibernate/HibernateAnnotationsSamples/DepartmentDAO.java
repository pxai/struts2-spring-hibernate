/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of departmentDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class DepartmentDAO implements DepartmentDAOInterface {

	/* 
	 * selects one department by Id
	 * @param id
	 * @return Department
	 */
	public Department selectById(int id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Department department = (Department) session.get(Department.class, id);
	    session.close();
	    return department;
	}

	/*
	 * retrieves all departments from db
	 * @return List of departments
	 */
	public List<Department> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();

	    	List<Department> departments = session.createQuery("from Department").list();
	   
	    //session.close();
	    return departments;
	}

	/*
	 * inserts a new department in database
	 * retrieves generated id and sets to department instance
	 * @param new department
	 */
	public void insert(Department department) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    Integer id = (Integer) session.save(department);
	    department.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates department
	 * @param department to update
	 */
	public void update(Department department) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(department);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * delete given department
	 * @param department to delete
	 */
	public void delete(Department department) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(department);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
