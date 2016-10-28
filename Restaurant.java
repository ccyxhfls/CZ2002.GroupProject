package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Restaurant {
	private FoodMgr foodMgr;
	private PromoSetMgr promoSetMgr;
	private OrderMgr orderMgr;
	private TableMgr tableMgr;
	private Availability availability;
	
	public Restaurant(){
		foodMgr = new FoodMgr("/Users/shiganyu/Documents/Eclipse/workspace/cz2002.groupProject/src/resterauntReservationApp/menuDB.csv");
		promoSetMgr = new PromoSetMgr("/Users/shiganyu/Documents/Eclipse/workspace/cz2002.groupProject/src/restaurantReservationApp/promoSet.txt");
	}
	
	public void addFood(int ID, String name, double price, int category) {
		foodMgr.addFood(ID, name, price, category);
		foodMgr.printMenu();
	}
	
	public void removeFood (int ID){
		foodMgr.removeFood(ID);
	}
	
	public void updateFood(int ID, int choice, String value ){
		switch (choice){
		case 1: //name
			foodMgr.updateName(ID, value);
		case 2:
			foodMgr.updatePrice(ID, Double.parseDouble(value));
		case 3:
			foodMgr.updateDescription(ID, value);
			
		}
		
	}
	
	public PromoSet addPromoSet(int ID){
		PromoSet promoSet = new PromoSet(ID);
		return promoSet;
	}
	
	public void addPromoSet(int ID, String name, String foodListStr, double price, String description) {
		ArrayList<Food> foodList = getFoodListFromID(foodListStr);
		promoSetMgr.addPromoSet(ID, name, foodList, price, description);
		
	}
	
	public void updatePromoSet(int ID, int choice, String value) {
		switch(choice){
		case 1: 
			promoSetMgr.updateName(ID, value);
			break;
		case 2:
			promoSetMgr.updatePrice(ID, Double.parseDouble(value));
			break;
		case 3:
			promoSetMgr.updateDescription(ID, value);
			break;
			
		}
	}
	
	public void updatePromoSet(int ID, double price) {
		promoSetMgr.updatePrice(ID, price);	
	}
	
	public void updateFood(int ID, double price) {
		foodMgr.updatePrice(ID, price);
		
	}
	
	public void removePromoSet(int ID) {
		promoSetMgr.removePromoSet(ID);
	}
	
	
	public Table getTable(int pax){
		Table table = tableMgr.searchAvailableTable(pax);
		table.occupy();
		return table;
	}
	
	public void addOrder(String food, String promoSet, Table table) {
		ArrayList<Food> foodList = getFoodListFromID(food);
		ArrayList<PromoSet> promoSetList = getPromoSetListFromID(promoSet);
		orderMgr.addOrder(foodList, promoSetList, table);
	}

	public ArrayList<Food> getFoodListFromID (String list){
		ArrayList<Food> foodList = new ArrayList<Food>();
		String[] ID = list.split(" ");
		for (int i = 0; i < ID.length; i++){
			Food food = foodMgr.searchFood(Integer.parseInt(ID[i]));
		}
		return foodList;
	}

	public ArrayList<PromoSet> getPromoSetListFromID(String list) {
		ArrayList<PromoSet> promoSetList = new ArrayList<PromoSet>();
		String[] ID = list.split(" ");
		for (int i = 0; i < ID.length; i++){
			PromoSet promoSet = promoSetMgr.searchPromoSet(Integer.parseInt(ID[i]));
		}
		return promoSetList;
	}

	public int getTable(String dateStr, String timeStr, int pax) {
		Calendar time = new GregorianCalendar();
		//manipulate time;
		int tableID = availability.checkAvailability(time, pax);
		return tableID;
	}

	public void reserveTable(String dateStr, String timeStr, int tableID, String name, String hp, int pax) {
		Calendar time = new GregorianCalendar();
		//manipulate time;
		availability.addReservation(tableID, name, hp, pax, time );
		
	}


	public void printCategories() {
		foodMgr.printCatetories();
		
	}

	

	

	

	

	

	
	
	

	
}
