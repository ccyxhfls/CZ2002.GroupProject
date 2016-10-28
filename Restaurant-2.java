package resterauntReservationApp;
import java.util.Scanner;
public class Restaurant {
	
	public static void main(String[]args){
		Menu menu =new Menu();
		TableMgr tableMgr = new TableMgr(); 	
		OrderMgr orderMgr = new OrderMgr();
		ReservationMgr reservationMgr =new ReservationMgr();
		StaffMgr staffMgr = new StaffMgr();
		MemberMgr memberMgr = new MemberMgr();
		Receipt receipt = new Receipt();
		Scanner sc=new Scanner(System.in);
		int choice,choice2, choice3, staffId,tableNumber, reservationId,id,numPeople,amount,orderId,membershipId;
		double price;
		boolean membershipStatus;
		String name, description,contact,dateTime;
		Food fo;
		PromoSet ps;
		do{
			System.out.println("1: Create/Update/Remove menu item ");
			System.out.println("2: Create/Update/Remove promotion");
			System.out.println("3: Create Order");
			System.out.println("4: View Order");
			System.out.println("5: Add/Remove order item/s to/from order");
			System.out.println("6: Create reservation booking");
			System.out.println("7: Check/Remove reservation booking");
			System.out.println("8: Check table availability");
			System.out.println("9: Print order invoice");
			System.out.println("10: Print sale revenue report by period");
			System.out.println("11: Quit");
			choice =sc.nextInt();
			switch(choice){
			case 1://add/update/remove food
				do{
					System.out.println("1: Create menu item");
					System.out.println("2: Update menu item");
					System.out.println("3: Remove menu item");
					System.out.println("4: Quit");
					choice2=sc.nextInt();
					switch(choice2){
					case 1://add food
						System.out.print("Name:");
						name =sc.nextLine();
						System.out.print("Price:");
						price=sc.nextDouble();
						System.out.print("Description:");
						fo = new Food(name,price,description);
						menu.addFood(fo);
						menu.printMenu();
						break;
					case 2://update food
						System.out.print("Enter the food id");
						id=sc.nextInt();
						fo = menu.getFoodById(id);
						do{
							System.out.println("1: Update name");
							System.out.println("2: Update price");
							System.out.println("3: Update description");
							System.out.println("4: Quit");
							choice3= sc.nextInt();
							switch(choice3){
							case 1:
								System.out.print("Enter food name:");
								name=sc.nextLine();
								fo.setName();
								menu.printMenu();
								break;
							case 2:
								System.out.print("Enter food price:");
								price=sc.nextDouble();
								fo.setPrice();
								menu.printMenu();
								break;
							case 3:
								System.out.print("Enter food description:");
								description=sc.nextLine();
								fo.setDescription();
								menu.printMenu();
								break;
							case 4:
								break;			
							
							}
						}while(choice3>0 &&choice3<4);
						break;
					case 3://remove food
						System.out.print("Enter the food id:");
						id=sc.nextInt();
						menu.removeFood(id);
						menu.printMenu();
						break;
					case 4:
						break;
					}
				}while(choice2>0&&choice2<4);
				break;
			case 2://add/update/remove promoset
				do{
					System.out.println("1: Create promotion");
					System.out.println("2: Update promotion");
					System.out.println("3: Remove promotion");
					System.out.println("4: Quit");
					choice2 = sc.nextInt();
					switch(choice2){
					case 1://add promoset
						System.out.print("Name:");
						name =sc.nextLine();
						System.out.print("Price:");
						price=sc.nextDouble();
						System.out.print("Description:");
						ps = new PromoSet(name,price, description);
						menu.addPromoSet(ps);
						menu.printMenu();
						break;
					case 2://update promoset//
						System.out.print("Enter the promotion id:");
						id=sc.nextInt();
						ps= menu.getPromoSetById(id);
						do{
							System.out.println("1: Update name");
							System.out.println("2: Update price");
							System.out.println("3: Update description");
							System.out.println("4: Quit");
							choice3= sc.nextInt();
							switch(choice3){
							case 1:
								System.out.print("Enter promotion name:");
								name = sc.nextLine();
								ps.setName(name);
								menu.printMenu();
								break;
							case 2:
								System.out.print("Enter promotion price:");
								price =sc.nextDouble();
								ps.setPrice();
								menu.printMenu();
								break;
							case 3:
								System.out.print("Enter promotion description:");
								description=sc.nextLine();
								ps.setDescription();
								menu.printMenu();
								break;
							case 4:
								break;
					
							}
						}while(choice3>0 && choice3<4);
						break;
					case 3://remove promoset
						System.out.print("Enter the promotion id:");
						id=sc.nextInt();
						menu.removePromoSet(id);
						menu.printMenu();
						break;
					case 4:
						break;
					}
				}while(choice2>0 && choice2<4);
				break;
			case 3://create an order
				System.out.print("Enter the table number:");
				tableNumber= sc.nextInt();
				table = tableMgr.getTableByNumber(tableNumber);				
				
				//check if the table is occupied
				if (table.tableStatus()==false)
					System.out.println("This table is not occupied");
				else{
					System.out.println("This table is occupied");
					continue;}
				
				//check the capacity
				System.out.println("Enter the number of people");
				numPeople=sc.nextInt();
				if (tableMgr.tableCapacity(tableNumber)>= numPeople)
					System.out.println("This table has enough capacity");
				else{
					System.out.println("This table is not big enough");
					continue;
				}
				
				// Assign a Staff to the Order
				System.out.print("Enter staff ID: ");
				staffId = sc.nextInt();
				staff = staffMgr.getStaffById(staffId);
				
								
				// Create new order 
				order = orderMgr.createOrder(table,staff);
				// get order id
				System.out.print("Give Id to this order:");
				orderId=sc.nextInt();
				order.setOrderId(orderId);
				// Print menu
				menu.printMenu();
				
				//add food
				do{
					System.out.println("1: Enter the food id and the amount");
					System.out.println("2: Quit");
					choice2=sc.nextInt();
					switch(choice2){
					case 1:
						System.out.print("Enter the food id:");
						id=sc.nextInt();
						fo=menu.getFoodById(id);
						Sytstem.out.print("Enter the amount:");
						amount=sc.nextInt();
						order.addFood(fo,amount);
						break;
					case 2:
						break;
					}
					
				}while(choice2<2 && choice2>0);
				//add promoset
				do{
					System.out.println("1: Enter the promoset id and the amount");
					System.out.println("2: Quit");
					choice2=sc.nextInt();
					switch(choice2){
					case 1:
						System.out.print("Enter the promoset id:");
						id=sc.nextInt();
						ps=menu.getPromoSetById(id);
						Sytstem.out.print("Enter the amount:");
						amount=sc.nextInt();
						order.addPromoSet(ps,amount);
						break;
					case 2:
						break;
					}
				}while(choice2<2 &&choice2>0);
				
				break;
			case 4://view order
				System.out.print("Enter the order id:");
				orderId=sc.nextInt();
				order= orderMgr.getOrderById(orderId);
				if(order ==null){
					System.out.println("This order does not exist.");
					}
				else:
					order.printOrder();
				break;
			case 5://Add/Remove order item/s to/from order
				System.out.print("Enter the order id:");
				orderId=sc.nextInt();
				order= orderMgr.getOrderById(orderId);
				if(order ==null){
					System.out.println("This order does not exist.");
					continue;}
			
				System.out.println("1: Add order items to order");
				System.out.println("2: Remove order items from order");
				System.out.println("3: Quit");
				choice2=sc.nextInt();
				switch(choice2) {
				case 1:	//add stuff to the order			
					menu.printMenu();
					//add food
					do{
						System.out.println("1: Enter the food id and the amount");
						System.out.println("2: Quit");
						choice2=sc.nextInt();
						switch(choice3){
						case 1:
							System.out.print("Enter the food id:");
							id=sc.nextInt();
							fo=menu.getFoodById(id);
							Sytstem.out.print("Enter the amount:");
							amount=sc.nextInt();
							order.addFood(fo,amount);
							break;
						case 2:
							break;
						}
						
					}while(choice3<2 && choice3>0);
					//add promoset
					do{
						System.out.println("1: Enter the promoset id and the amount");
						System.out.println("2: Quit");
						choice2=sc.nextInt();
						switch(choice2){
						case 1:
							System.out.print("Enter the promoset id:");
							id=sc.nextInt();
							ps=menu.getPromoSetById(id);
							Sytstem.out.print("Enter the amount:");
							amount=sc.nextInt();
							order.addPromoSet(ps,amount);
							break;
						case 2:
							break;
						}
					}while(choice2<2 &&choice2>0);
					break;
				case 2:
					order.printOrder();
					//remove food
					do{
						System.out.println("1: Enter the food id and the amount");
						System.out.println("2: Quit");
						choice2=sc.nextInt();
						switch(choice3){
						case 1:
							System.out.print("Enter the food id that you want to remove:");
							id=sc.nextInt();
							//should i check if the food that customer wants to remove is not in the order?
							fo=menu.removeFoodById(id);
							Sytstem.out.print("Enter the amount that you want to remove:");
							amount=sc.nextInt();
							order.removeFood(fo,amount);
							break;
						case 2:
							break;
						}
						
					}while(choice3<2 && choice3>0);
					//remove promoset
					do{
						System.out.println("1: Enter the promoset id and the amount");
						System.out.println("2: Quit");
						choice2=sc.nextInt();
						switch(choice2){
						case 1:
							System.out.print("Enter the promoset id that you want to remove:");
							id=sc.nextInt();
							//should i check if the promoset that customer wants to remove is not in the order?
							ps=menu.removePromoSetById(id);
							System.out.print("Enter the amount that you want remove:");
							amount=sc.nextInt();
							order.removePromoSet(ps,amount);
							break;
						case 2:
							break;
						}
					}while(choice2<2 &&choice2>0);
				
				break;
			case 6://Reservation booking
				System.out.print("Pleases enter the customer name:");
				name = sc.nextLine();
				
				//check membership status
				System.out.println("Does the customer have a membership?");
				System.out.println("1: Yes");
				System.out.println("2: No");
				choice2=sc.nextInt();
				switch(choice2){
				case 1:
					System.out.println("Please enter the membership id");
					membershipId=sc.nextInt();
					if (memberMgr.checkMembershipId(membershipIs)==true){
						System.out.println("This customer has membership");
						membershipStatus= true;}
					else{
						System.out.println("Wrong membership Id");
						membershipStatus =false;}
					
					//////??????????????
					break;
				case 2:
					membershipStatus =false;
					break;
				}
			
				System.out.print("Please enter the contact number: ");
				contact = sc.nextLine();
				
				// customer detail
				customerDetail = reservationMgr.customerDetail(name, membershipStatus, contact);
				
				// Input date and time of the reservation
				System.out.println("Please input the date and time: ");
				dateTime = sc.nextLine();
				// can ask the customer to input in the form of string
				// hr AM/PM DD MM YYYY
				//eg 0800AM01012016
				//???
				
				//need to check if the time slot is avalable
				//im stuck here
				 
				System.out.print("Please enter the number of people: ");
				numPeople = sc.nextInt();
				table = tableMgr.allocateTable(numPeople);
				
				
				if (table == null) {
					println("There is no available table");
				} 
				else 
					reservationId= reservationMgr.createReservation(customerDetail,dateTime,table);
				
				break;
			case 7:// Check/Remove reservation booking
				
				System.out.print("Please enter reservation ID: ");
				reservationId = sc.nextInt();					
				
				System.out.println("1: Check reservation");
				System.out.println("2: Remove reservation");
				System.out.println("3: Quit");
				
				choice2 = sc.nextInt();
				
				switch (choice2) {
				case 1:
					
					if (reservationMgr.checkReservation(reservationId) == false) {
						System.out.println("The reservation does not exist");
					}
					else
						reservationMgr.printReservation(reservationId);
					
					break;
					
				case 2:
					if (reservationMgr.checkReservation(reservationId) == false) {
						System.out.println("The reservation does not exist");
					}
					else{
						reservationMgr.removeReservation(reservationId);
						System.out.println("The reservation has been removed");}
					
					break;
				}
				break;
			case 8://Check table availability
				// Input table number / ID
				System.out.print("Please enter the table number: ");
				tableNumber = sc.nextInt();				
				table = tableMgr.getTableByNumber(tableNumber);				
				if (table == null) {
					System.out.println("This talbe does not exist");
				} else {
					// Check whether the Table is available
					if (table.tableStatus()==false) {
						System.out.println("This table is not available");
					} else {
						System.out.println("This table isavailable");
					}
				}
				
				break;
			case 9://print invoice order
				
				System.out.print("Enter the order id:");
				orderId=sc.nextInt();
				order= orderMgr.getOrderById(orderId);
				if(order ==null){
					System.out.println("This order does not exist.");
					}
				else
				{
					System.out.println("Does the customer have a membership?");
					System.out.println("1: Yes");
					System.out.println("2: No");
					choice2=sc.nextInt();
					switch(choice2){
					case 1:
						System.out.println("Please enter the membership id");
						membershipId=sc.nextInt();
						if (memberMgr.checkMembershipId(membershipIs)==true){
							System.out.println("This customer has membership");
							receipt.printReceiptMember(order);}
						else{
							System.out.println("Wrong membership Id");
							receipt.printReceiptNoMember(order);
							}
						
						
						break;
					case 2:
						receipt.printReceiptNoMember(order);
						break;
						
					}
					}
				break;			
				
			case 10://revenue
				System.out.println("1: Revenue by day");
				System.out.println("2: Revenue by month");
				System.out.println("3: Quit");
				choice2=sc.nextInt();
				switch(choice2){
				case 1:
					System.out.println("Please enter the date:");
					dateTime=sc.nextLine();
					receipt.revenueDay(dateTime);
					break;
				case 2:
					System.out.println("Please enter the month:");
					dateTime=sc.nextLine();
					receipt.revenueMonth(dateTime);
					break;
				case 3:
					break;
				}
				break;
			case 11:
				break;
			}
		}while(choice>0 && choice<11);	
	
           
	}
}
//*Qns: promoset linked with food???
//should we create table, staff in the form of database
//when remove/update promoset/food should check if the thing exists in the menu
//when add food/promoset should create a copy???
	//.................