/**
 * 
 */
package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Represents a company Department
 * @author Pello Altadill
 * @greetz for those who keep on working even in summertime
 */
@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="main_department")
	private int mainDepartmentId; 
	
	@OneToMany(mappedBy="mainDepartment")
    private Set<Department> departments;
    

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="main_department", insertable = false, updatable = false)
	private Department mainDepartment;
	
	/**
	 * default constructor needed by hibernate
	 */
	public Department () {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param mainDepartment
	 */
	public Department(int id, String name, String description,int mainDepartmentId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.mainDepartmentId = mainDepartmentId;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description="
				+ description + ", mainDepartmentId=" + mainDepartmentId + "]";
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mainDepartment
	 */
	public int getMainDepartmentId() {
		return mainDepartmentId;
	}

	/**
	 * @param mainDepartment the mainDepartment to set
	 */
	public void setMainDepartmentId(int mainDepartmentId) {
		this.mainDepartmentId = mainDepartmentId;
	}

	/**
	 * @return the departments
	 */
	public Set<Department> getDepartments() {
		return departments;
	}

	/**
	 * @param departments the departments to set
	 */
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	/**
	 * @return the mainDepartment
	 */
	public Department getMainDepartment() {
		return mainDepartment;
	}

	/**
	 * @param mainDepartment the mainDepartment to set
	 */
	public void setMainDepartment(Department mainDepartment) {
		this.mainDepartment = mainDepartment;
	}



	
}
