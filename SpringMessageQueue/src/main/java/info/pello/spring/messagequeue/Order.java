package info.pello.spring.messagequeue;

import java.io.Serializable;

/**
 * Represents a product order
 * @author Pello Altadill
 * @greetz any
 */
public class Order implements Serializable {
	private String product;
	private int qty;
	
	/**
	 * default constructor
	 */
	public Order () {
		
	}

	/**
	 * @param product
	 * @param qty
	 */
	public Order(String product, int qty) {
		this.product = product;
		this.qty = qty;
	}



	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [product=" + product + ", qty=" + qty + "]";
	}
	
}
