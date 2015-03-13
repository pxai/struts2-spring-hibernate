package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

/**
 * interface for CarDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface CarDAOInterface {
	
	public Car selectById(int id);
	public List<Car> selectAll ();
	public void insert (Car car);
	public void update (Car car);
	public void delete (Car car);

}
