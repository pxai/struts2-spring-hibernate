package org.cuatrovientos.struts;


import java.util.List;

/**
 * interface for RoleDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface RoleDAOInterface {
	
	public Role selectById(int id);
	public List<Role> selectAll ();
	public void insert (Role role);
	public void update (Role role);
	public void delete (Role role);

}
