package restaurantReservationApp;

import java.util.ArrayList;

import restaurantReservationApp.Food.Category;

public class PromoSet {
	private ArrayList<Food> foodList;
	private String name;
	private int ID;
	private double totalPrice;
	private double promoPrice;
	
	public PromoSet (String[] metaData){
		ID = Integer.parseInt(metaData[0]);
		totalPrice = Double.parseDouble(metaData[0]);
		promoPrice = Double.parseDouble(metaData[0]);
	}
	
	public PromoSet (String name, double totalPrice, double PromoPrice){
		setName(name);
		setTotalPrice(totalPrice);
		setPromoPrice(promoPrice);
	}
	
	public int getID(){
		return ID;
	}

	
	public void setID(int ID){
		this.ID= ID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public void setTotalPrice(double totalPrice){
		this.totalPrice = totalPrice;
	}
	
	public void setPromoPrice(double promoPrice){
		this.promoPrice = promoPrice;
	}
	
	public Food addFood(Food food){
		foodList.add(food);
		return food;
	}
	
	public Food removeFood(Food food){
		foodList.remove(food);
		return food;
	}

}
