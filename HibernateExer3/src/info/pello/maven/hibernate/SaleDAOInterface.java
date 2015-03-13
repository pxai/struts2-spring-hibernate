package info.pello.maven.hibernate;


import java.util.List;

/**
 * interface for SaleDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface SaleDAOInterface {
	
	public Sale selectById(int id);
	public List<Sale> selectAll ();
	public void insert (Sale sale);
	public void update (Sale sale);
	public void delete (Sale sale);

}
