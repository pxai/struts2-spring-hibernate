package info.pello.maven.hibernate;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for Hibernate Exercise 1
 * @author Pello Xabier Altadill Izura
 * @greetz 4 u
 * @listening http://www.youtube.com/watch?v=LPIZbBH-FNY
 */
public class Main  {
	
	
	/**
	 * simple function for reusing
	 * @param sellerDAO
	 */
	public static void showAll (SellerDAO sellerDAO) {
		// SELECT ALL DATA
    	List<Seller> sellers = sellerDAO.selectAll();
        
    	System.out.println("\n--- seller ----- table contents -----------");
        
        for(Seller seller : sellers) {
        	System.out.print("Id: " + seller.getId());
        	System.out.print(" - Name: " + seller.getName());
        	System.out.println(" - Percentage: " + seller.getPercentage());
        }

        System.out.println("Total sellers: " + sellers.size());	
	}
	

	
	/**
	 * main function
	 * @param args
	 */
    public static void main( String[] args )
    {
    	Scanner reader = new Scanner(System.in);
    	SellerDAO sellerDAO = new SellerDAO();
    	Seller seller = null;
    	String option = "";
    	String line = "";
    	

    	do {
    		System.out.println("Choose option:");
    		System.out.println("1.- Insert new Seller");
    		System.out.println("2.- Show all");
    		System.out.println("3.- Update");
    		System.out.println("4.- Delete");
    		System.out.println("5.- Get me out of here");

    		option = reader.nextLine();
    		
    		switch (option) {
    			case "1":	
    						seller = new Seller();
    						System.out.print("Name: ");
    						seller.setName(reader.nextLine());
    						
    						System.out.println("Percentage: ");
    						seller.setPercentage(Float.parseFloat(reader.nextLine()));
    						
    						sellerDAO.insert(seller);
    						break;
    						
    			case "2":
    						showAll(sellerDAO);
    						break;
    						
    			case "3":
							seller = new Seller();
							System.out.print("Id to update: ");
							seller.setId(Integer.parseInt(reader.nextLine()));
							
							System.out.print("New name: ");
							seller.setName(reader.nextLine());
							
							System.out.println("New percentage: ");
							seller.setPercentage(Float.parseFloat(reader.nextLine()));
							
							sellerDAO.update(seller);
							break;
							
    			case "4":
							seller = new Seller();
							System.out.print("Id to delete: ");
							seller.setId(Integer.parseInt(reader.nextLine()));
							sellerDAO.delete(seller);
							break;
							
    			case "5":
    						System.out.println("See you around!");
    						break;
    				
    			default :
    						System.out.println("Learn to enter what you are asked for");
    						break;
    		}
    		
    	} while (!option.equals("5"));    	
    	
    	System.out.println("Thnx for using this.");
    	
        
    	
     
    }
}
