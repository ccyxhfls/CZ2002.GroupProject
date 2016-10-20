package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Iterator;

import restaurantReservationApp.Food.Category;

public class FoodMgr {
	ArrayList<Food> foodList;
	
	public Food addFood (int ID, String name, double price, Category cat){
		Food food = new Food(ID, name, price, cat);
		foodList.add(food);
		return food;
	}
	
	public Food removeFood (int ID){
		Food food = searchFood(ID);
		foodList.remove(food);
		return food;
	}
	
	public Food updateName(int ID, String name){
		Food food = searchFood(ID);
		food.setFoodName(name);
		return food;
	}
	
	public Food updatePrice(int ID, int price){
		Food food = searchFood(ID);
		food.setFoodPrice(price);
		return food;
	}
	
	private Food searchFood(int ID){
		Iterator<Food> itr = foodList.iterator();
		while(itr.hasNext()){
			Food food = itr.next();
			if (food.getFoodID() == ID){
				return food;
			}
		}
		return null;
	}
	
	
}
