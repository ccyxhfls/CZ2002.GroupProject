package restaurantReservationApp;



public class Food extends MenuItem{
	public static enum KindOfFood{
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
	
	private KindOfFood category;
	
	
	public Food (String[] attributes){
		ID = Integer.parseInt(attributes[0]);
		category = KindOfFood.valueOf(attributes[1]);
		name = attributes[2];
		price = Double.parseDouble(attributes[3]);
	}

	public Food(int ID, String name, double price, int category) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.category = KindOfFood.values()[category-1];
	}

	public KindOfFood getCategory(){
		return category;
	}
	
	
	public String toString(){
		
		String format = "%1$-5d %2$-20s %3$-50s %4$-10.2f";
		String output = String.format(format, this.ID, this.category, this.name, this.price);
		return output;
	}

	
}
