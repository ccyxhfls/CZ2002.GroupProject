package restaurantReservationApp;


public class MenuItem {
	protected int ID;
	protected String name;
	protected double price;
	protected String description;
	protected double discountPrice;
	
	public int getID(){
		return ID;
	}

	public void setID(int ID){
		this.ID= ID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
		
	}
	public void setDiscountPrice(double discountPrice){
		this.discountPrice = discountPrice;
	}
	
	public double getDiscountPrice(){
		return discountPrice;
	}
	
	

}
