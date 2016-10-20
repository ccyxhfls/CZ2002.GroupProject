package restaurantReservationApp;

public class Food {
	public static enum Category{
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
	
	private int foodID;
	private String foodName;
	private double foodPrice;
	private Category foodCategory;
	
	public Food (String[] metaData){
		foodID = Integer.parseInt(metaData[0]);
		foodCategory = Category.valueOf(metaData[1]);
		foodName = metaData[2];
		foodPrice = Double.parseDouble(metaData[3]);
	}
	
	public Food (int ID, String name, double price, Category cat){
		setFoodID(ID);
		setFoodName(name);
		setFoodPrice(price);
		setFoodCategory(cat);
	}
	
	public int getFoodID(){
		return foodID;
	}
	
	public String getFoodName(){
		return foodName;
	}
	
	public double getFoodPrice(){
		return foodPrice;
	}
	
	public Category getFoodCategory(){
		return foodCategory;
	}
	
	public void setFoodCategory(Category cat){
		foodCategory = cat;
	}
	
	public void setFoodID(int id){
		foodID= id;
	}
	
	public void setFoodName(String name){
		foodName = name;
	}
	
	
	public void setFoodPrice(double price){
		foodPrice = price;
	}
	
	public String toString(){
		
		String format = "%1$-5d %2$-20s %3$-50s %4$-10.2f";
		String output = String.format(format, this.foodID, this.foodCategory, this.foodName, this.foodPrice);
		return output;
	}
}
