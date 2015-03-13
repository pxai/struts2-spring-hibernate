package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

/**
 * interface for ProductDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface ProductDAOInterface {
	
	public Product selectById(int id);
	public List<Product> selectAll ();
	public void insert (Product product);
	public void update (Product product);
	public void delete (Product product);

}
