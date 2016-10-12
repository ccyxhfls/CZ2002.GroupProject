package resterauntReservationApp;

import java.util.*;

public class RRPSS {

	private static Menu menu = new Menu("/Users/shiganyu/Documents/Eclipse/workspace/cz2002.groupProject/src/resterauntReservationApp/menuDB.csv");
	
	public static void main(String[] args) {
		menu.printMenu();
		Scanner sc = new Scanner (System.in);
		int choice;
		do {
			System.out.println("(1) Create menu item ");
			System.out.println("(2) Update menu item ");
			System.out.println("(3) Remove menu item ");
			System.out.println("(4) Create promotion item ");
			System.out.println("(5) Update promotion item ");
			System.out.println("(6) Remove promotion item ");
			System.out.println("(7) Create order ");
			System.out.println("(8) View order ");
			System.out.println("(9) Add order item ");
			System.out.println("(10) Remove order item ");
			System.out.println("(11) Create Reservation booking");
			System.out.println("(12) Check reservation booking");
			System.out.println("(13) Remove reservation booking");
			System.out.println("(14) Check table availability");
			System.out.println("(15) Print order invoice");
			System.out.println("(16) Print sale revenue report by period");
			System.out.println("(17) Quit");
			
			choice = sc.nextInt();
			switch(choice){
				case 1: {menu.addMenuItem(); break;}
				case 2: {menu.updateMenuItem(); break;}
				case 3: {menu.removeMenuItem(); break;}
				case 4: {menu.addPromotionalPackages();break;}
				case 5: {menu.updatePromotionalPackage();break;}
				case 6: {menu.removePromotionalPackage();break;}
				case 17: break;
				default:{System.out.println("ERROR");}
			}
		}while (choice != 17);
	}

}
