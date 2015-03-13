package org.cuatrovientos.struts;


import java.util.List;

/**
 * interface for UserDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface UserDAOInterface {
	
	public User selectById(int id);
	public boolean checkLogin(String login, String password);
	public List<User> selectAll ();
	public void insert (User user);
	public void update (User user);
	public void delete (User user);

}
