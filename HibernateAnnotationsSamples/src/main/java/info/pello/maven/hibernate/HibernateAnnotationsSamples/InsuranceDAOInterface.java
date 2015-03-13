package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

/**
 * interface for InsuranceDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface InsuranceDAOInterface {
	
	public Insurance selectById(int id);
	public List<Insurance> selectAll ();
	public void insert (Insurance insurance);
	public void update (Insurance insurance);
	public void delete (Insurance insurance);

}
