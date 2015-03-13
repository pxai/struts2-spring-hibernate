package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

/**
 * interface for DepartmentDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface DepartmentDAOInterface {
	
	public Department selectById(int id);
	public List<Department> selectAll ();
	public void insert (Department department);
	public void update (Department department);
	public void delete (Department department);

}
