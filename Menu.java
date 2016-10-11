package resterauntReservationApp;

import java.util.*;

public class Menu {
	List<Item> items = new ArrayList<Item>();
	List<PromotionalPackage> promotionalPackages = new ArrayList<PromotionalPackage>();
	private int numOfItems;
	private int numOfPackages;

	public void addPromotionalPackages(){
		Scanner sc = new Scanner(System.in);
		printMenu();
		PromotionalPackage pp = new PromotionalPackage();
		System.out.print("Enter number of items in the package: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++){
			System.out.print("Enter item ID to be added to a package: ");
			int itemID = sc.nextInt();
			pp.addItem(items.get(itemID-1));
		}
		promotionalPackages.add(pp);
		numOfPackages++;
		printMenu();
	}
	
	public void updatePromotionalPackage(){
		Scanner sc = new Scanner(System.in);
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
				pp.addItem(items.get(itemID-1));
				break;
			}
			case 2: {
				System.out.println("Enter item name to remove: ");
				String itemName = sc.next();
				pp.removeItem(itemName);
				break;
			}
			default: System.out.println("ERROR");
		}
		printMenu();
	}
	
	public void removePromotionalPackage(){
		printMenu();
		System.out.print("Enter ID of the package to be removed: ");
		Scanner sc = new Scanner(System.in);
		int packageID = sc.nextInt();
		promotionalPackages.remove(packageID);
		numOfPackages--;
		printMenu();
	}
	
	public void addMenuItem(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter item name: ");
		String name = sc.next();
		System.out.print("Enter item price: ");
		double price = sc.nextDouble();
		System.out.print("Enter item category: 1 for main course, 2 for drinks, 3 for dessert ");
		int categoryValue = sc.nextInt();

		items.add (new Item(name, price, categoryValue));
		numOfItems ++;
		System.out.println();
		System.out.println("Added to menu");
		printMenu();
		
	}
	
	public void removeMenuItem(){
		printMenu();
		System.out.print("Enter ID of the item to be removed: ");
		Scanner sc = new Scanner(System.in);
		int itemID = sc.nextInt();
		items.remove(itemID);
		numOfItems--;
		printMenu();
	}
	
	public void updateMenuItem(){
		printMenu();
		System.out.print("Enter ID of the item to be updated: ");
		Scanner sc = new Scanner(System.in);
		int itemID = sc.nextInt();
		Item item = items.get(itemID);
		
		System.out.print("Enter the information to be updated: 1 for name, 2 for price, 3 for Category ");
		int choice = sc.nextInt();
		switch(choice){
			case 1: {
				System.out.println("Enter new name:");
				String name = sc.next();
				item.setItemName(name);
				break;
			}
			case 2: {
				System.out.println("Enter new price:");
				double price = sc.nextDouble();
				item.setItemPrice(price);
				break;
			}
			case 3: {
				System.out.println("Enter new category: 1 for main course, 2 for drinks, 3 for dessert");
				int categoryValue = sc.nextInt();
				item.setItemCategory(categoryValue);
				break;
			}
			default: System.out.println("ERROR");
		}
		printMenu();
	}
	
	public void printMenu(){
		System.out.println("-------------------MENU-------------------");
		System.out.printf("%-5s %-15s %-15s %-15s", "ID", "Category", "Name", "Price(S$)" );
		System.out.println();
		System.out.println("----------------ALA CARTE-----------------");
		for (int i = 0; i < numOfItems; i++){
			System.out.printf("%-5d %-15s %-15s %-10.2f \n", (i+1) , items.get(i).getItemCategory(), items.get(i).getItemName(), items.get(i).getItemPrice());
		}
		System.out.println("----------------PROMOTION-----------------");
		for (int i = 0; i < numOfPackages; i++){
			PromotionalPackage pp = promotionalPackages.get(i);
			int n = pp.getNumOfItems();
			List<Item> items = pp.getItems();
			for (int j = 0 ; j < n; j++){
				if (j == 0)
					System.out.printf("%-5s %-15s %-15s %-10.2f \n", (i+1) ,items.get(j).getItemCategory(), items.get(j).getItemName(), pp.getPackagePrice());
				else
					System.out.printf("%-5c %-15s %-15s %-10c \n", ' ' , items.get(j).getItemCategory(), items.get(j).getItemName(), ' ');
			}
			System.out.println();
		}
		System.out.println("-------------------END--------------------");
	}
}
