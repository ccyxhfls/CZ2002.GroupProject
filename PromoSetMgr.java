package restaurantReservationApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;


public class PromoSetMgr {
	private ArrayList<PromoSet> promoSetList = new ArrayList<PromoSet>();
	
	public PromoSetMgr (String fileName){
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
			int numOfSet = Integer.parseInt(br.readLine());
			for (int i = 0; i < numOfSet; i++){
				int setID = Integer.parseInt(br.readLine());
				PromoSet promoSet = new PromoSet(setID);
				int numOfFood = Integer.parseInt(br.readLine());
				for (int j = 0; j< numOfFood; j++){
					String foodStr = br.readLine();
					String[] attributes = foodStr.split(",");
					int foodID = Integer.parseInt(attributes[0]);
					Food food = FoodMgr.searchFood(foodID);
					promoSet.addFood(food);
				}
				double discountPrice = Double.parseDouble(br.readLine());
				promoSet.setDiscountPrice(discountPrice);
				promoSetList.add(promoSet);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	
	public void addPromoSet(int ID, String name, ArrayList<Food> foodList, double price, String description) {
		PromoSet promoSet = new PromoSet(ID, name, foodList, price, description);
		promoSet.print();
		promoSetList.add(promoSet);
	}
	
	public PromoSet removePromoSet(int ID){
		PromoSet promoSet = searchPromoSet(ID);
		promoSetList.remove(promoSet);
		return promoSet;
	}
	  PromoSet searchPromoSet(int ID){
		Iterator<PromoSet> itr = promoSetList.iterator();
		while(itr.hasNext()){
			PromoSet promoSet = itr.next();
			if (promoSet.getID() == ID){
				return promoSet;
			}
		}
		return null;
	}
	
	public PromoSet addFood (int ID, Food food){
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.addFood(food);
		return promoSet;
	}
	
	public PromoSet removeFood (int ID, Food food){
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.removeFood(food);
		return promoSet;
	}
	
	public void printPromoSet(){
		Iterator<PromoSet> itr = promoSetList.iterator();
		while(itr.hasNext()){
			PromoSet promoSet = itr.next();
			promoSet.print();
		}
	}


	public void updateName(int ID, String name) {
		PromoSet promoSet = searchPromoSet(ID);

	}


	public void updatePrice(int ID, double price) {
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.setDiscountPrice(price);
	}


	public void updateDescription(int ID, String description) {
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.setDescription(description);
		
	}


	
}
