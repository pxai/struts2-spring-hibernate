/**
 * 
 */
package info.pello.validation;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
// Check for hibernate annotations
import org.hibernate.validator.constraints.*;

/**
 * Represents a Customer, with annotations for validation
 * based os JSR 303 spec
 * @author Pello Altadill
 * @greetz any
 */
public class Customer {
	
	@Min(value=1,message="ID must be 1 or bigger")
	private int id;
	
	@NotNull(message="Name cannot be null")
	private String name;
	
	@NotNull(message="Surname cannot be null")
	private String surname;
	
	@NotNull(message="Birth cannot be null")
	private Date birth;
	
	
	/**
	 * default constructor
	 */
	public Customer () {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param birth
	 */
	public Customer(int id, String name, String surname, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", birth=" + birth + "]";
	}
	
	
}
