package resterauntReservationApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category {
	
	public static enum KindOfItem{
		ADVANCEDORDER,
		APPETIZER,
		SOUP,
		FISH,
		FRESHPRAWN,
		CLASSICZICHAR,
		VEGETABLE,
		EGGNTOFU,
		DESSERT,
		NOODLENRICE,
		HOTDRINK,
		COLDDRINK,
		FRESHJUICE,
		BEER
	};
	

	KindOfItem kind;
	
	private List<Item> items = new ArrayList<Item>();
	
	
	public static void printListOfCategory(){
		System.out.println("1: ADVANCED ORDER");
		System.out.println("2: APPETIZER");
		System.out.println("3: SOUP");
		System.out.println("4: FISH");
		System.out.println("5: FRESH PRAWN");
		System.out.println("6: CLASSIC ZI CHAR");
		System.out.println("7: VEGETABLE");
		System.out.println("8: EGG & TOFU");
		System.out.println("9: DESSERT");
		System.out.println("10: NOODLE & RICE");
		System.out.println("11: BEVERAGES/HOT DRINKS");
		System.out.println("12: BEVERAGES/FRESH JUICE");
		System.out.println("13: BEVERAGES/BEER");
	}
	
	public static KindOfItem getCategoryFromItemID(int itemID){
		return KindOfItem.values()[itemID/100 -1];
	}
	
	public Category(int i){
		kind = KindOfItem.values()[i];
	}
	
	public Category(KindOfItem kind){
		this.kind = kind;
	}
	
	public KindOfItem getCategory(){
		return kind;
	}
	
	public int getValue(){
		return kind.ordinal();
	}
	
	public int getNumOfItems(){
		return items.size();
	}
	
	public void addItemToCategory(Item item){
		items.add(item);
		int itemID = (kind.ordinal()+1) * 100 + items.size();
		item.setItemID(itemID);
	}
	
	
	
	public Item searchItemByCategory(int itemID){
		Iterator<Item> itr = items.iterator();
		while(itr.hasNext()){
			Item item = itr.next();
			if (item.getItemID() == itemID){
				return item;
			}
		}
		return null;
	}
	
	public boolean removeItemFromCategory(int itemID){
		Item item = searchItemByCategory(itemID);
		if ( item != null){
			items.remove(item);
			return true;
		}
		else
			return false;
	}
	
	public boolean updateItemInCategory (int itemID) {
		Item item = searchItemByCategory(itemID);
		if (item != null){
			item.updateItem();
			return true;
		}
		return false;
	}
	
	public void printItemsByCategory() {
		for (int i = 0; i < items.size(); i++){
			items.get(i).printItem();
		}
	}
	
	/*
	List<Item> advancedOrder = new ArrayList<Item>();
	List<Item> appetizer = new ArrayList<Item>();
	List<Item> soup = new ArrayList<Item>();
	List<Item> fish = new ArrayList<Item>();
	List<Item> freshPrawn = new ArrayList<Item>();
	List<Item> classicZiChar = new ArrayList<Item>();
	List<Item> vegetable = new ArrayList<Item>();
	List<Item> eggNTofu = new ArrayList<Item>();
	List<Item> dessert = new ArrayList<Item>();
	List<Item> noodleNRice = new ArrayList<Item>();
	List<Item> hotDrink = new ArrayList<Item>();
	List<Item> freshJuice = new ArrayList<Item>();
	List<Item> beer = new ArrayList<Item>();
	
	public void addItemToCategory(KindOfItem kind, Item item){
		switch(kind){
		case ADVANCEDORDER:
			advancedOrder.add(item);
		case APPETIZER:
			appetizer.add(item);
		case SOUP:
			soup.add(item);
		case FISH:
			fish.add(item);
		case FRESHPRAWN:
			freshPrawn.add(item);
		case CLASSICZICHAR:
			classicZiChar.add(item);
		case VEGETABLE:
			vegetable.add(item);
		case EGGNTOFU:
			eggNTofu.add(item);
		case DESSERT:
			dessert.add(item);
		case NOODLENRICE:
			noodleNRice.add(item);
		case HOTDRINK:
			hotDrink.add(item);
		case FRESHJUICE:
			freshJuice.add(item);
		case BEER:
			beer.add(item);
		}
	}
	*/
	
	
}
