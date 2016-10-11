package resterauntReservationApp;

import java.util.*;

import resterauntReservationApp.Item.Category;

public class Menu {
	Item[] items = new Item[50];
	int total = 0;
	
	public void addMenuItem(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter item name:");
		String name = sc.next();
		System.out.println("Enter item price:");
		double price = sc.nextDouble();
		System.out.println("Enter item category: 1 for main course, 2 for drinks, 3 for dessert");
		int categoryValue = sc.nextInt();
		Category category;
		switch (categoryValue){
		case 1:
			category = Category.mainCourse; break;
		case 2:
			category = Category.drink; break;
		case 3:
			category = Category.dessert; break;
		default: category = Category.mainCourse;
		}
		
		items[total++] = new Item (name, price, category);
		System.out.println("Added to menu");
		printMenu();
		
	}
	
	public void deleteMenuItem(){
		System.out.println("Enter ID of the dish to be deleted:");
		printMenu();
		System.out.println("Enter ID of the dish to be deleted:");
		Scanner sc = new Scanner(System.in);
		int dishID = sc.nextInt();
		for(int i = dishID; i < total; i++){
			items[i-1] = items[i];
		}
		printMenu();
		
		
	}
	
	public void printMenu(){
		System.out.println("-------------------MENU-------------------");
		System.out.printf("%-5s %-10s %-10s %-15s", "ID", "Name", "Price(S$)", "Category" );
		System.out.println();
		System.out.println("------------------------------------------");
		for (int i = 0; i < total; i++){
			System.out.printf("%-5d %-10s %-10.2f %-15s", (i+1) , items[i].getItemName(), items[i].getItemPrice(),items[i].getItemCategory());
			System.out.println();
		}
		System.out.println("-------------------END-------------------");
	}
}
