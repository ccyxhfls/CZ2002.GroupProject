package resterauntReservationApp;

import resterauntReservationApp.Item.Category;

public class Item {
	public enum Category {mainCourse, drink, dessert};
	
	private String itemName;
	private double itemPrice;
	private Category itemCategory;
	private String itemDescription;
	

	public Item(String name, double price, int categoryValue){
		itemName = name;
		itemPrice = price;
		setItemCategory(categoryValue);
		itemDescription = "This is a " + itemCategory.toString();
	}
	
	
	public String getItemName(){
		return itemName;
	}
	
	public double getItemPrice(){
		return itemPrice;
	}
	
	public String getItemCategory(){
		return itemCategory.toString();
	}
	
	public String getItemDescription(){
		return itemDescription;
	}
	
	
	public void setItemName(String name){
		itemName = name;
	}
	
	public void setItemPrice(double price){
		itemPrice = price;
	}
	
	public void setItemCategory(int categoryValue){
		switch (categoryValue){
		case 1:
			itemCategory = Category.mainCourse; break;
		case 2:
			itemCategory = Category.drink; break;
		case 3:
			itemCategory = Category.dessert; break;
		default: System.out.println("ERROR");
		}
	}
	
	public void setItemDescription(String description){
		itemDescription = description;
	}
}
