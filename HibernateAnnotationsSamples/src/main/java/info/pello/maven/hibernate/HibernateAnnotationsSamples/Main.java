package info.pello.maven.hibernate.HibernateAnnotationsSamples;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Main class
 * @author Pello Xabier Altadill Izura
 * @greetz 4 u
 * @listening "Seasons in the Abyss - Slayer"
 * Close your eyes 
 * Look deep in your soul 
 * Step outside yourself 
 * And let your mind go 
 * Frozen eyes stare deep in your mind as you die 
 */
public class Main  {
	
	
	/**
	 * shows all departments
	 * @param departmentDAO
	 */
	public static void showAllDepartments (DepartmentDAOInterface departmentDAO) {
		// SELECT ALL DATA
    	List<Department> departments = departmentDAO.selectAll();
        
    	System.out.println("\n--- DEPARTMENT: ----- table contents -----------");
        
        for(Department department : departments) {
        	System.out.print("Id: " + department.getId());
        	System.out.println(" - Name: " + department.getName());
        	System.out.println(" - Description: " + department.getDescription());
        /*	if (null != department.getMainDepartment()) {
            	System.out.println(" - Main Department ID: " + department.getMainDepartment().getId());        		
        	}*/
        	
        	/*for (Department subdept : department.getDepartments()) {
        		System.out.println("Subdepartment: " + subdept.toString());
        	}*/
        }

        System.out.println("Total Departments: " + departments.size());	
	}
	
	/**
	 * simple function for reusing
	 * @param customerDAO
	 */
	public static void showAll (CustomerDAO customerDAO) {
		// SELECT ALL DATA
    	List<Customer> customers = customerDAO.selectAll();
        
    	System.out.println("\n--- CUSTOMER ----- table contents -----------");
        
        for(Customer customer : customers) {
        	System.out.print("Id: " + customer.getId());
        	System.out.println(" - Name: " + customer.getName());
        }

        System.out.println("Total Customers: " + customers.size());	
	}
	
	/**
	 * simple function for reusing
	 * @param customerDAO
	 */
	public static void showAllCars (CarDAOInterface carDAO) {
		// SELECT ALL DATA
    	List<Car> cars = carDAO.selectAll();
        
    	System.out.println("\n--- CARS ----- table contents -----------");
        
        for(Car car : cars) {
        	System.out.print("Id: " + car.getId());
        	System.out.print(" - Model: " + car.getModel());
        	System.out.println(" - Insurance: " + car.getInsurance().getCompany());
        }

        System.out.println("Total cars: " + cars.size());	
	}
	
	
	/**
	 * simple function for reusing
	 * @param productDAOInterface
	 */
	public static void showAllProducts (ProductDAOInterface productDAOInterface) {
		// SELECT ALL DATA
    	List<Product> products = productDAOInterface.selectAll();
    	String productDesc = "";
        
    	System.out.println("\n--- Products ----- table contents -----------");
        
        for(Product product : products) {
        	productDesc = "Id: " + product.getId() + 
        					" - Name: " + product.getName() +
        					" - Type: " + product.getProductType().getName();
        	System.out.println(productDesc);
        }

        System.out.println("Total products: " + products.size());	
	}

	/**
	 * simple function for reusing
	 * @param productDAOInterface
	 */
	public static void showAllProductTypes (ProductTypeDAOInterface productTypeDAO) {
		// SELECT ALL DATA
    	List<ProductType> productTypes = productTypeDAO.selectAll();
    	String productDesc = "";
        
    	System.out.println("\n--- ProductsTypes ----- table contents -----------");
        
        for(ProductType productType : productTypes) {
        	productDesc = "Id: " + productType.getId() + 
        					" - Name: " + productType.getName() +
        					" - Products: \n";
        	productDesc += productType.getProducts().toString() + "\n";
        	
        	System.out.println(productDesc);
        }

        System.out.println("Total products: " + productTypes.size());	
	}

	
	/**
	 * simple function for reusing
	 * @param userDAOInterface
	 */
	public static void showAllUsers (UserDAOInterface userDAOInterface) {
		// SELECT ALL DATA
    	List<User> users = userDAOInterface.selectAll();
    	String userDesc = "";
        
    	System.out.println("\n--- Users ----- table contents -----------");
        
        for(User user : users) {
        	userDesc = "Id: " + user.getId() + 
        					" - Name: " + user.getLogin() + 
        					" - Roles: " + user.getRoles().toString();
        	System.out.println(userDesc);
        }

        System.out.println("Total users: " + users.size());	
	}
	
	/**
	 * simple function for reusing
	 * @param userDAOInterface
	 */
	public static void showAllRoles (RoleDAOInterface roleDAOInterface) {
		// SELECT ALL DATA
    	List<Role> roles = roleDAOInterface.selectAll();
    	String roleDesc = "";
        
    	System.out.println("\n--- Roles ----- table contents -----------");
        
        for(Role role : roles) {
        	roleDesc = "Id: " + role.getId() + 
        					" - Name: " + role.getName() +
        					" - Description: " + role.getDescription();
        	System.out.println(roleDesc);
        }

        System.out.println("Total roles: " + roles.size());	
	}
	
	/**
	 * main function
	 * @param args
	 */
    public static void main( String[] args )
    {
    	/*
    	CustomerDAO customerDAO = new CustomerDAO();
    	showAll(customerDAO);
            
        // SELECT JUST ONE
        Customer oneCustomer = customerDAO.selectById(1);
    	System.out.println("Selected Name: " + oneCustomer.getName());
    	
        // INSERT NEW DATA
    	Customer newCustomer = new Customer(0,"Phil Anselmo","Suicide note","phil@pantera.com");
    	customerDAO.insert(newCustomer);
    	System.out.println("Inserted id: " + newCustomer.getId());
    	
        System.out.println("Show data after new insert");
    	showAll(customerDAO);
        
        // UPDATE DATA
        newCustomer.setName("Dimebag Darrell");
        customerDAO.update(newCustomer);

        System.out.println("Show data after update");
    	showAll(customerDAO);
        
        // DELETE DATA
        customerDAO.delete(newCustomer);

        System.out.println("Show data after deletion");
    	showAll(customerDAO);
        */
    	/*
    	CarDAOInterface carDAO = new CarDAO();
    	
    	showAllCars(carDAO);
    	
        // SELECT JUST ONE
        Car oneCar = carDAO.selectById(1);
    	System.out.println("Selected Name: " + oneCar.getRegistration());
    	
        // INSERT NEW DATA
    	Insurance insurance = new Insurance("Lagun Aro","Full",666.66);
    	Car newCar = new Car(0,"5646DFR","Volkswagen passat");
    	newCar.setInsurance(insurance);
    	insurance.setCar(newCar);
    	
    	carDAO.insert(newCar);
    	
    	System.out.println("Inserted id: " + newCar.getId());
    	
        System.out.println("Show data after new insert");
    	showAllCars(carDAO);
        
        // UPDATE DATA
        newCar.setModel("Seat Panda TDI");
        carDAO.update(newCar);

        System.out.println("Show data after update");
    	showAllCars(carDAO);
        
        // DELETE DATA
        carDAO.delete(newCar);
        */
/*
    	ProductDAOInterface productDAO = new ProductDAO();
    	ProductTypeDAOInterface productTypeDAO = new ProductTypeDAO();
    	
    	showAllProducts(productDAO);
    	
    	
        // SELECT JUST ONE
        Product oneProduct = productDAO.selectById(1);
    	System.out.println("Selected Name: " + oneProduct.getName());
    	
    	
        // INSERT NEW DATA
    	ProductType productType = new ProductType("Luxurious");
    	productTypeDAO.insert(productType);
    	Product newProduct = new Product("Angulas","Angulas de Aginaga", productType);
    	
    	productDAO.insert(newProduct);
    	
    	System.out.println("Inserted id: " + newProduct.getId());
    	
        System.out.println("Show data after new insert");
    	showAllProducts(productDAO);
        
        // UPDATE DATA
        newProduct.setName("Piperrark");
        productDAO.update(newProduct);

        System.out.println("Show data after update");
    	showAllProducts(productDAO);
        
        // DELETE DATA
        productDAO.delete(newProduct);
    	showAllProducts(productDAO);
    	
    	showAllProductTypes(productTypeDAO);
	*/
    	/*
    	UserDAOInterface userDAO = new UserDAO();
    	RoleDAOInterface roleDAO = new RoleDAO();
    	
    	showAllUsers(userDAO);
    	
    	
        // SELECT JUST ONE
        User oneUser = userDAO.selectById(1);
    	System.out.println("Selected Name: " + oneUser.getLogin());
    	
    	
        // INSERT NEW DATA
    	Role role = new Role(0,"default","Another role");
    	roleDAO.insert(role);
    	HashSet<Role> roles = new HashSet<Role>();
    	roles.add(role);
    	
    	User newUser = new User(0,"newuser","1234567","newuser@gmail.com");
    	newUser.setRoles(roles);
    	
    	userDAO.insert(newUser);
    	
    	System.out.println("Inserted id: " + newUser.getId());
    	
        System.out.println("Show data after new insert");
    	showAllUsers(userDAO);
        
        // UPDATE DATA
        newUser.setLogin("changed");
        userDAO.update(newUser);

        System.out.println("Show data after update");
    	showAllUsers(userDAO);
        
        // DELETE DATA
        userDAO.delete(newUser);
    	showAllUsers(userDAO);
    	
    	showAllRoles(roleDAO);*/
    	DepartmentDAOInterface departmentDAO = new DepartmentDAO();
    	showAllDepartments(departmentDAO);
    }
}
