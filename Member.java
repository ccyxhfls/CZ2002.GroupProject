package restaurantReservationApp;

public class Member {
	String name;
	String IC;
	String gender;
	String hp;
	int pts;
	
	public Member(String name, String IC, String gender, String hp){
		this.name = name;
		this.IC = IC;
		this.gender = gender;
		this.hp = hp;
		pts = 0;
	}
	
	public String getIC(){
		return IC;
	}
	
	public void setHp(String hp){
		this.hp = hp;
	}
	
	
	

}
