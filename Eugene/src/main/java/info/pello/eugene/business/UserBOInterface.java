package info.pello.eugene.business;

import java.util.List;

import info.pello.eugene.model.User;



/**
 * interface to define all user related operations
 * @author Pello Altadill
 * @greetz Any 
 */
public interface UserBOInterface {
	public User selectById(int id);

	public List<User> selectAll();

	public List<User> search(String description);

	public void deleteById(int id);

	public void insert(User user);

	public void update(User user);

}
