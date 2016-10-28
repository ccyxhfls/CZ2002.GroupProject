package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Iterator;

public class PromoSet extends MenuItem {
	ArrayList<Food> foodList;

	public PromoSet(int ID){
		this.ID = ID;
		foodList = new ArrayList<Food>();
	}
	
	public PromoSet (String[] metaData){
		ID = Integer.parseInt(metaData[0]);
		price = Double.parseDouble(metaData[1]);
		discountPrice = Double.parseDouble(metaData[2]);
	}
	
	public PromoSet(int ID, String name, ArrayList<Food> foodList, double price, String description) {
		this.ID = ID;
		this.name = name;
		this.foodList = foodList;
		System.out.println(foodList.size());
		
		this.discountPrice = price;
		this.description = description;
		
	}

	public Food addFood(Food food){
		foodList.add(food);
		price += food.getPrice();
		return food;
	}
	
	public Food removeFood(Food food){
		foodList.remove(food);
		price -= food.getPrice();
		return food;
	}

	public void print() {
		System.out.println("Set ID:" + ID);
		
		Iterator<Food> itr = foodList.iterator();
		while(itr.hasNext()){
			Food food = itr.next();
			System.out.println(food.toString());
		}
		System.out.println("total:" + price);
		System.out.println("discount price:" + discountPrice);

	}
	
	
}
