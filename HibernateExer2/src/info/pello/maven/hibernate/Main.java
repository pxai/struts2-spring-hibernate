package info.pello.maven.hibernate;


import java.util.ArrayList;
import java.util.Date;
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
	 * @param selletDAO
	 */
	public static void showAll (SellerDAO selletDAO) {
		// SELECT ALL DATA
    	List<Seller> sellers = selletDAO.selectAll();
        
    	System.out.println("\n--- sellet ----- table contents -----------");
        
        for(Seller seller : sellers) {
        	System.out.print("Id: " + seller.getId());
        	System.out.print(" - Name: " + seller.getName());
        	System.out.println(" - Percentage: " + seller.getPercentage());
        	// Now we show seller's sales
        	if (null != seller.getSales()) {
        		for (Sale sale : seller.getSales()) {
        			System.out.print("\tSaleId: " + sale.getId());
        			System.out.print("Description: " + sale.getDescription());
        			System.out.println("Date: " + sale.getSaledate());
        		}
                System.out.println("Total sales: " + seller.getSales().size());	
        	}
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
    	SaleDAO saleDAO = new SaleDAO();
    	Seller seller = null;
    	String option = "";
    	String line = "";
    	


    	// Insert
    	seller = new Seller();
 		System.out.print("Name: ");
 		seller.setName(reader.nextLine());
    						
    	System.out.println("Percentage: ");
    	seller.setPercentage(Float.parseFloat(reader.nextLine()));
    	
    	sellerDAO.insert(seller);
    						
    	Sale sale = new Sale();
    	System.out.println("Sale description:");
    	sale.setDescription(reader.nextLine());
    	sale.setSaledate(new Date());
    	sale.setSeller(seller);
    	saleDAO.insert(sale);
    	
    	
    	HashSet<Sale> sales = new HashSet<Sale>();
    	sales.add(sale);
    	seller.setSales(sales);
    	sellerDAO.update(seller);
    	
    	// Select All
		showAll(sellerDAO);
    			
		// Update
		seller = new Seller();
		System.out.print("Id to update: ");
		seller.setId(Integer.parseInt(reader.nextLine()));
				
		System.out.print("New name: ");
		seller.setName(reader.nextLine());
							
		System.out.println("New percentage: ");
		seller.setPercentage(Float.parseFloat(reader.nextLine()));
							
		sellerDAO.update(seller);

    	// Select All
		showAll(sellerDAO);

		// Delete
		seller = new Seller();
		System.out.print("Id to delete: ");
		seller.setId(Integer.parseInt(reader.nextLine()));
		sellerDAO.delete(seller);

    	// Select All
		showAll(sellerDAO);

		
		System.out.println("Thnx for using this.");
    	
        
     
    }
}
