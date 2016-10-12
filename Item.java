package resterauntReservationApp;

import java.util.Scanner;

import resterauntReservationApp.Category.KindOfItem;


public class Item {

	private int itemID;
	private String itemName;
	private double itemPrice;
	private KindOfItem itemCategory;
	private int item_vegan;
	private int item_chefRecommend;
	private int item_spicy;
	private String itemDescription;
	
	public Item(){
		setItemName();
		setItemPrice();
		setItemCategory();
	}

	public Item(String[] metaData){
		itemID = Integer.parseInt(metaData[0]);
		itemCategory = KindOfItem.valueOf(metaData[1]);
		itemName = metaData[2];
		itemPrice = Double.parseDouble(metaData[3]);
		item_vegan = Integer.parseInt(metaData[4]);
		item_chefRecommend = Integer.parseInt(metaData[5]);
		item_spicy = Integer.parseInt(metaData[6]);
		itemDescription = setItemDescription();
	}
	
	public String setItemDescription(){
		StringBuilder sb = new StringBuilder();
		if (item_vegan == 1)
			sb.append("*Vegan*");
		if (item_chefRecommend == 1)
			sb.append("*Chef recommend*");
		if (item_spicy == 1)
			sb.append("*Spicy*");
		return (sb.toString());
	}
	
	public void setItemID(int id){
		itemID= id;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public double getItemPrice(){
		return itemPrice;
	}
	
	public KindOfItem getItemCategory(){
		return itemCategory;
	}
	
	
	public void setItemName(String name){
		itemName = name;
	}
	
	public void setItemPrice(double price){
		itemPrice = price;
	}
	
	public void setItemCategory(KindOfItem kind){
		itemCategory = kind;
	}
	
	public void setItemName(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.next();
		setItemName(name);
	}
	
	public void setItemPrice(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter price:");
		double price = sc.nextDouble();
		setItemPrice(price);
	}
	
	public void setItemCategory(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Category number:");
		Category.printListOfCategory();
		int categoryValue = sc.nextInt();
		KindOfItem kind = KindOfItem.values()[categoryValue-1];
		setItemCategory(kind);
	}
	
	public void updateItem(){
		setItemName();
		setItemPrice();
	}
	public void printItem(){
		System.out.printf("%-5d %-20s %-50s %-10.2f %-40s \n", itemID , itemCategory, itemName, itemPrice, itemDescription);
	}
}
