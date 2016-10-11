package resterauntReservationApp;

import java.util.*;

public class PromotionalPackage {
	static final double DISCOUNT = 0.9;
	List<Item> items = new ArrayList<Item>();
	private int numOfItems;
	private double totalPrice;
	private double packagePrice;
	
	public void setNumOfItems (int n){
		numOfItems = n;
	}
	
	public int getNumOfItems(){
		return numOfItems;
	}

	public double getPackagePrice(){
		return packagePrice;
	}
	public List<Item> getItems() {
		return items;
	}
	public void addItem (Item item){
		items.add(item);
		numOfItems++;
		totalPrice += item.getItemPrice();
		packagePrice = totalPrice * DISCOUNT;
	}
	
	public boolean removeItem (String name){
		Iterator<Item> itr = items.iterator();
		while(itr.hasNext()){
			Item item = itr.next();
			if (item.getItemName().equalsIgnoreCase(name)){
				items.remove(item);
				numOfItems--;
				totalPrice -= item.getItemPrice();
				packagePrice = totalPrice * DISCOUNT;
				return true;
			}
		}
		return false;
		
	}
}
