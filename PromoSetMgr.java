package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Iterator;


public class PromoSetMgr {
	private ArrayList<PromoSet> promoSetList;
	
	public PromoSet AddPromoSet (String name, double totalPrice, double promoPrice){
		PromoSet promoSet = new PromoSet(name, totalPrice, promoPrice);
		promoSetList.add(promoSet);
		return promoSet;
	}
	
	public PromoSet removePromoSet(int ID){
		PromoSet promoSet = searchPromoSet(ID);
		promoSetList.remove(promoSet);
		return promoSet;
	}
	
	private PromoSet searchPromoSet(int ID){
		Iterator<PromoSet> itr = promoSetList.iterator();
		while(itr.hasNext()){
			PromoSet promoSet = itr.next();
			if (promoSet.getID() == ID){
				return promoSet;
			}
		}
		return null;
	}
	
	public PromoSet addFood (ArrayList<PromoSet> promoSetList, int ID, Food food){
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.addFood(food);
		return promoSet;
	}
	
	public PromoSet removeFood (ArrayList<PromoSet> promoSetList, int ID, Food food){
		PromoSet promoSet = searchPromoSet(ID);
		promoSet.removeFood(food);
		return promoSet;
	} 
}
