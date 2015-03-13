package info.pello.maven.hibernate;


import java.util.List;

/**
 * interface for SellerDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface SellerDAOInterface {
	
	public Seller selectById(int id);
	public List<Seller> selectAll ();
	public void insert (Seller seller);
	public void update (Seller seller);
	public void delete (Seller seller);

}
