package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

/**
 * interface for UserDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface UserDAOInterface {
	
	public User selectById(long id);
	public List<User> selectAll ();
	public void insert (User user);
	public void update (User user);
	public void delete (User user);

}
