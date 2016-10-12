package resterauntReservationApp;

import java.util.*;

public class PromotionalPackage {
	Scanner sc = new Scanner(System.in);
	
	static final double DISCOUNT = 0.9;
	List<Item> items = new ArrayList<Item>();
	private double totalPrice;
	private double packagePrice;
	

	public PromotionalPackage(){
	}
	
	public int getNumOfItems(){
		return items.size();
	}

	public double getTotalPrice(){
		return totalPrice;
	}
	
	public double getPackagePrice(){
		return packagePrice;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void addItemToPackage (Item item){
		items.add(item);
		totalPrice += item.getItemPrice();
		packagePrice = totalPrice * DISCOUNT;
	}
	
	public void addItemToPackage (){
		Item item = new Item();
		items.add(item);
		totalPrice += item.getItemPrice();
		packagePrice = totalPrice * DISCOUNT;
	}
	
	public Item searchItemInPackage(int itemID){
		Iterator<Item> itr = items.iterator();
		while(itr.hasNext()){
			Item item = itr.next();
			if (item.getItemID() == itemID){
				return item;
			}
		}
		return null;
	}
	
	public boolean removeItemInPackage (int itemID){
		Item item = searchItemInPackage(itemID);
		if ( item != null){
			items.remove(item);
			return true;
		}
		else
			return false;
	}
	
	public boolean updateItemInPackage (int itemID){
		Item item = searchItemInPackage(itemID);
		if (item != null){
			item.updateItem();
			return true;
		}
		return false;
	}
	
	public void printPromotionalPackage(){
		for (int i = 0; i< items.size(); i++){
			items.get(i).printItem();
		}
		System.out.println();
		System.out.printf("%77s %-10.2f \n", "Total Price", totalPrice);
		System.out.printf("%77s %-10.2f \n", "Package Price", packagePrice);
	}
}
