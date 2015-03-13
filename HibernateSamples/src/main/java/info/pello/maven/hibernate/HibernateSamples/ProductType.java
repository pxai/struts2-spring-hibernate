/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.Set;

/**
 * Represents a ProductType
 * @author Pello Altadill
 * @greetz any kind of bread
 */
public class ProductType {
	private int id;
	private String name;
	private Set<Product> products;
	
	/**
	 * default constructor
	 */
	public ProductType () {
		
	}

	/**
	 * @param name
	 */
	public ProductType(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
