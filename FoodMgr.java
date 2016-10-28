package restaurantReservationApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import restaurantReservationApp.Food.KindOfFood;
import resterauntReservationApp.MenuItem;
import resterauntReservationApp.Category.KindOfItem;


public class FoodMgr {
	private static ArrayList<Food> foodList = new ArrayList<Food>();
	
	public FoodMgr (String fileName){
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_16)){
			String line = br.readLine();
			while(line != null){
				String[] attributes = line.split(",");
				addFood(attributes);
				line = br.readLine();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	
	public void addFood (String[] attributes){
		Food food = new Food(attributes);
		foodList.add(food);
	}
	
	public void addFood (int ID, String name, double price, int category){
		Food food = new Food(ID, name, price, category);
		int index = getIndexFromCategory(category);
		foodList.add(index, food);
	}
	
	public void removeFood (int ID){
		try{
			Food food = searchFood(ID);
			foodList.remove(food);
			System.out.println("Food successfully removed!");
			System.out.println(food.toString());
		} catch (NullPointerException e){
			System.out.println("Invalid ID");
		}
	}
	
	public void updateName(int ID, String name){
		try{
			Food food = searchFood(ID);
			food.setName(name);
			System.out.println("Successfully updated!");
			System.out.println(food.toString());
		} catch (NullPointerException e){
			System.out.println("Invalid ID");
		}
	}
	
	public void updatePrice(int ID, double price){
		try{
			Food food = searchFood(ID);
			food.setPrice(price);
			System.out.println("Successfully updated!");
			System.out.println(food.toString());
		} catch (NullPointerException e){
			System.out.println("Invalid ID");
		}	
	}
	
	public void updateDescription(int ID, String description) {
		try{
			Food food = searchFood(ID);
			food.setDescription(description);
			System.out.println("Successfully updated!");
			System.out.println(food.toString());
		} catch (NullPointerException e){
			System.out.println("Invalid ID");
		}	
		
	}
	
	public static Food searchFood(int ID){
		Iterator<Food> itr = foodList.iterator();
		while(itr.hasNext()){
			Food food = itr.next();
			if (food.getID() == ID){
				return food;
			}
		}
		throw new NullPointerException();
	}
	
	private int getIndexFromCategory(int category){
		int index_last = 0;
		Iterator<Food> itr = foodList.iterator();
		while(itr.hasNext()){
			Food food = itr.next();
			if (food.getCategory().ordinal() > category -1 ){
				break;
			}
			else{
				index_last++;
			}
		}
		return index_last;
	}
	
	public void printMenu(){
		Iterator<Food> itr = foodList.iterator();
		while(itr.hasNext()){
			Food food = itr.next();
			System.out.println(food.toString());
		}
	}
	
	public void printCatetories(){
		System.out.println();
		for (int i = 0; i< KindOfFood.values().length; i++){
			System.out.printf("%d: %s \n", i+1, KindOfFood.values()[i]);
		}
	}


	
}
