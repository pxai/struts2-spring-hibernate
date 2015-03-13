package info.pello.eugene.dao;


import info.pello.eugene.model.User;

import java.util.List;

/**
 * interface for UserDAO class
 * @author Pello Altadill, with regards for Daniel Lacasta
 *
 */
public interface UserDAOInterface {
	
	public User selectById(int id);
	public List<User> selectAll ();
	public void insert (User User);
	public void update (User User);
	public void delete (User User);
	public void deleteById (int id);
	public List<User> search(String name);

}
