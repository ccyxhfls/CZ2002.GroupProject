package resterauntReservationApp;

import java.util.*;


public class Menu {
	Scanner sc = new Scanner(System.in);
	
	public static final int NUMOFCATEGORIES  = 14;
	private Category[] categories;
	List<PromotionalPackage> promotionalPackages;
	IOHandler io = new IOHandler();
	
	public Menu(String fileName){
		categories = new Category[NUMOFCATEGORIES];
		promotionalPackages = new ArrayList<PromotionalPackage>();
		for (int i = 0; i < NUMOFCATEGORIES; i++){
			categories[i] = new Category(i);
		}
		io.loadMenuFromFile(fileName, categories);
	}
	
	public int getNumOfCategories () {
		return NUMOFCATEGORIES;
	}

	public int getNumOfItems(){
		int totalItem = 0;
		for (int i = 0; i < NUMOFCATEGORIES; i++){
			totalItem += categories[i].getNumOfItems();
		}
		return totalItem;
	}
	
	public int getNumOfPackages(){
		return promotionalPackages.size();
	}

	public Item searchItemByID (int itemID){
		int categoryValue = itemID/100;
		Item item = categories[categoryValue-1].searchItemByCategory(itemID);
		return item;
	}
	
	public void addPromotionalPackages(){
		printMenu();
		PromotionalPackage pp = new PromotionalPackage();
		System.out.print("Enter number of items in the package: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++){
			System.out.print("Enter item ID to be added to a package: ");
			int itemID = sc.nextInt();
			Item item = searchItemByID (itemID);
			if (item != null)
				pp.addItemToPackage(item);
			else
				System.out.println("ERROR");
		}
		promotionalPackages.add(pp);
		printMenu();
	}
	
	public void updatePromotionalPackage(){
		
		printMenu();
		System.out.print("Enter ID of the package to be updated: ");
		int packageID = sc.nextInt();
		PromotionalPackage pp = promotionalPackages.get(packageID -1);
		System.out.print("Enter the information to be updated: 1-add new item to package, 2-remove item from package");
		int choice = sc.nextInt();
		switch(choice) {
			case 1: {
				System.out.println("Enter item ID to add: ");
				int itemID = sc.nextInt();
				Item item = searchItemByID(itemID);
				pp.addItemToPackage(item);
				break;
			}
			case 2: {
				System.out.println("Enter item ID to remove: ");
				int itemID = sc.nextInt();
				pp.removeItemInPackage(itemID);
				break;
			}
			default: System.out.println("ERROR");
		}
		printMenu();
	}
	
	public void removePromotionalPackage(){
		printMenu();
		System.out.print("Enter ID of the package to be removed: ");
		
		int packageID = sc.nextInt();
		promotionalPackages.remove(packageID-1);
		printMenu();
	}
	
	public void addMenuItem(){
		Item item = new Item();
		int categoryValue = item.getItemCategory().ordinal();
		categories[categoryValue].addItemToCategory(item);
		System.out.println("Added to menu");
		printMenu();
		
	}
	
	public void removeMenuItem(){
		printMenu();
		System.out.print("Enter ID of the item to be removed: ");
		int itemID = sc.nextInt();
		int categoryValue = itemID/100;
		categories[categoryValue-1].removeItemFromCategory(itemID);
		printMenu();
	}
	
	public void updateMenuItem(){
		
		
		printMenu();
		System.out.print("Enter ID of the item to be updated: ");
		int itemID = sc.nextInt();
		int categoryValue = itemID/100;
		categories[categoryValue-1].updateItemInCategory(itemID);
		printMenu();
	}
	
	public void printMenu(){
		//System.out.println("DEBUG in printMenu" + items.size());
		System.out.println("************************************************************************************");
		System.out.println("                                        MENU                                        ");
		System.out.println("************************************************************************************");
		System.out.printf("%-5s %-20s %-50s %-10s", "ID", "Category", "Name", "Price(S$)" );
		System.out.println();
		System.out.println("-------------------------------------ALA CARTE--------------------------------------");
		for (int i = 0; i < NUMOFCATEGORIES; i++) {
			categories[i].printItemsByCategory();
		}
		System.out.println("************************************************************************************");
		System.out.println("                                        PROMOTION                                        ");
		System.out.println("************************************************************************************");
		if (promotionalPackages.size() == 0)
			System.out.println("N.A");
		for (int i = 0; i < promotionalPackages.size(); i++){
			System.out.println("PACKAGE ID: " + (i+1));
			promotionalPackages.get(i).printPromotionalPackage();
			System.out.println("-----------------------------------------------------------------------------------");
		}
		System.out.println("----------------------------------------END----------------------------------------");
	}
}
