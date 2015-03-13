package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.List;

/**
 * interface for ProductTypeDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface ProductTypeDAOInterface {
	
	public ProductType selectById(int id);
	public List<ProductType> selectAll ();
	public void insert (ProductType productType);
	public void update (ProductType productType);
	public void delete (ProductType productType);

}
