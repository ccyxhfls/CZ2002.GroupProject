package restaurantReservationApp;

import java.util.ArrayList;
import java.util.Scanner;


public class RRPSS {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Restaurant restaurant = new Restaurant();
		int choice, choice2, choice3;
		do 
		{
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
			
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: //add/update/remove menu item
				{
					System.out.println("1: Create menu item");
					System.out.println("2: Update menu item");
					System.out.println("3: Remove menu item");
					System.out.println("4: Quit");
					choice2=sc.nextInt();
					
					switch(choice2)
					{
						case 1://add food
						{
	                        System.out.print("ID:");
	                        int id = sc.nextInt();
	                        sc.nextLine(); // flush
							System.out.print("Name:");
							String name =sc.nextLine();
							System.out.print("Price:");
							double price=sc.nextDouble();
							System.out.print("Category:");
							restaurant.printCategories();
							int category = sc.nextInt();
							System.out.print("Description:");
		                    String description = sc.nextLine();
		                    restaurant.addFood(id, name, price, category);
		                    break;
						}
						case 2://update food
						{
							System.out.print("Enter the food id");
							int id=sc.nextInt();
							do
							{
								System.out.println("1: Update name");
								System.out.println("2: Update price");
								System.out.println("3: Update description");
								System.out.println("4: Quit");
								choice3= sc.nextInt();
								sc.nextLine(); // flush
								if (choice3>0 && choice3<4)
								{
									System.out.println("New Value:");
									String value = sc.nextLine();
									restaurant.updateFood(id, choice3, value);
								}
							}while(choice3>0 &&choice3<4);
							break;
						}
						case 3://remove food
						{
							System.out.print("Enter the food id:");
							int id=sc.nextInt();
							restaurant.removeFood(id);
							break;
						}
						case 4: //quit
						{
							break;
						}
						default:
						{
							System.out.println("Wrong data input");
							break;
						}
					}
					break;
				}
				
				
				case 2://add/update/remove promoset
				{
					System.out.println("1: Create promotion");
					System.out.println("2: Update promotion");
					System.out.println("3: Remove promotion");
					System.out.println("4: Quit");
					choice2 = sc.nextInt();
					switch(choice2)
					{
						case 1://add promoset
						{
							System.out.println("ID:");
							int id = sc.nextInt();
							System.out.print("Name:");
							String name =sc.nextLine();
							System.out.println("food id list:");
							String foodListStr = sc.nextLine();
							System.out.print("Price:");
							double price=sc.nextDouble();
							System.out.print("Description:");
							String description =sc.nextLine();
							restaurant.addPromoSet(id, name, foodListStr, price, description);
							break;
						}
						case 2://update promoset//
						{
							System.out.print("Enter the promotion id:");
							int id=sc.nextInt();
							do
							{
								System.out.println("1: Update name");
								System.out.println("2: Update price");
								System.out.println("3: Update description");
								System.out.println("4: Quit");
								choice3= sc.nextInt();
								if (choice3>0 && choice3<4)
								{
									System.out.println("New value");
									String value = sc.nextLine();
									restaurant.updatePromoSet(id, choice3, value);
								}
							}while(choice3>0 && choice3<4);
							break;
						}
						
						case 3://remove promoSet
						{
							System.out.print("Enter the promotion id:");
							int id=sc.nextInt();
							restaurant.removePromoSet(id);
							break;
						}
						case 4: // quit
						{
							break;
						}
						default:
						{	
							System.out.println("wrong input");
							break;
						}
					}		
					break;
				}
				
				case 7: 
				{
					System.out.println("pax:");
					int pax = sc.nextInt();
					Table table = restaurant.getTable(pax);
					sc.nextLine(); //flash
					System.out.println("food:");
					String food = sc.nextLine();
					System.out.println("promo set:");
					String promoSet = sc.nextLine();
					restaurant.addOrder(food, promoSet, table);
					break;
				}
				case 11: 
				{
					System.out.println("Date:");
					String date = sc.next();
					System.out.println("Time:");
					String time = sc.next();
					System.out.println("pax:");
					int pax = sc.nextInt();
					int tableID = restaurant.getTable(date, time, pax);
					System.out.println("table" + tableID + "is reserved for you");
					System.out.println("Name:");
					String name = sc.next();
					System.out.println("hp:");
					String hp = sc.next();
					restaurant.reserveTable(date, time, tableID, name, hp, pax);
				}
				default:{
					{System.out.println("ERROR");}
					break;
				}
			}
			
		}while (choice != 11);
	}
}
