/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.Set;


//We need all of these for annotations
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Represents a ProductType
 * @author Pello Altadill
 * @greetz any kind of bread
 */
@Entity
@Table(name="producttype")
public class ProductType {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	 @OneToMany(mappedBy="productType")
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
