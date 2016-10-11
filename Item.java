package resterauntReservationApp;

public class Item {
	public enum Category {mainCourse, drink, dessert};
	
	private String itemName;
	private double itemPrice;
	private Category itemCategory;
	private String itemDescription;
	

	public Item(String name, double price, Category category){
		itemName = name;
		itemPrice = price;
		itemCategory = category;
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
	
	public void setItemCategory(Category category){
		itemCategory = category;
	}
	
	public void setItemDescription(String description){
		itemDescription = description;
	}
}
