package com.petstore.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static com.petstore.utils.PetStoreUtility.*;

import com.petstore.entities.Category;
import com.petstore.entities.Order;
import com.petstore.entities.Pet;
import com.petstore.exception.AuthenticationException;
import com.petstore.exception.AuthorizationException;

public class PetTester {

	public static void main(String[] args) {

		Map<Integer, Pet> petMap = new HashMap<>();
		//String name, Category category, double price, int stock
		Pet pet = new Pet("Perro",Category.DOG, 2000, 10);
		petMap.put(pet.getPetid(), pet);
		Map<Integer, Order> orderMap = new HashMap<>();
		Map<String, String> user = new HashMap<>();
		user.put("admin", "admin");
		user.put("c1", "c1");
		String currentuser = null;
		boolean isAdmin = false;
		boolean exit = false;

		try (Scanner sc = new Scanner(System.in)) {

			while (!exit) {

				System.out.println("1)Login/SignIn : ");
				System.out.println("2)Add new Pet (Admin only functionality");
				System.out.println("3)Update Pet details (Admin only functionality)");
				System.out.println("4)Display all available pets");
				System.out.println("5)Order a Pet");
				System.out.println("6)Check order status by Order Id");
				System.out.println("7)Update order status (Admin only functionality)\r\n");
				System.out.println("0)Exit would u stop bunking lectures Pratik really its not like u"
						+ "You being rogue like I want my old Honest Pratik Back Kind Shy Innocent...");
				// See everything has reasons i have my reason i did'nt choose to go rogue like
				// First of all I DON'T WANT MONEY !! BUT I NEED IT
				// i am doing all of this thing to have good future
				// i can't change past what happened to me is irreversible but future is mine
				// I or we can change it Bruh Thanks for Supporting me but
				// We are playing a losing game really i want you to takeover me but i still
				// want to be me
				// which is impossble There is nothing like u or me ALL here IS I
				// People are noticing me they have eyes Stop switching we had agreement
				// I am done with this crazyness of mine talking to myself i am gonna go home
				// this
				// STAURDAY talk to my mother !! Mine she is my mother not urs and never will be

				System.out.println("\nEnter your choice Bruh I made this so u won't have any contribution :");
				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println("Enter username and password : ");
						String username = sc.next();
						String password = sc.next();
						if (userLogin(username, password, user)) {

							currentuser = username;
							isAdmin = "admin".equals(username) ? true : false;
							System.out.println("Logged In Successfully");
							System.out.println("whO IS THE WHAT IT RETURN"+user.get(username));
						} else
							throw new AuthenticationException("Invalid Credentials");
						break;
					case 2:
						if (isLoggedIn(currentuser) && isAdmin) {
							System.out.println("Enter Name Category price stock ");
							System.out.println(
									addPet(sc.next(), sc.next().toUpperCase(), sc.nextDouble(), sc.nextInt(), petMap));

						} else
							throw new AuthorizationException("Unauthorized operation");
						break;
//				addPet(String name, String category, double price, int stock, Map<Integer, Pet> petMap) {

					case 3:
						if (isLoggedIn(currentuser) && isAdmin) {
							System.out.println("int petid, String name, String category, double price, int stock"); // LAzy
																													// bstrd
							// i am typing since 3hrs already please dont use slang i want to be good person
							// in life
							System.out.println(updatePetDetails(sc.nextInt(), sc.next(), sc.next().toUpperCase(),
									sc.nextDouble(), sc.nextInt(), petMap));
						} else
							throw new AuthorizationException("Unauthorized operation");
						break;

					case 4:
						System.out.println("Display all Pets");
						displayAllpets(petMap);
						break;

					case 5:
						System.out.println("Order a pet ");
						System.out.println("int petid, int quantity");
						System.out.println(orderPet(sc.nextInt(),sc.nextInt(), orderMap, petMap));
						break;
					case 6:
						System.out.println("Check out order status by order id");
						checkOrderStatus(sc.nextInt(), orderMap);
						break;
					case 7:
						if (isLoggedIn(currentuser) && isAdmin) {
							System.out.println("ENter order id and status Mr Admin");
							updateOrderStatus(sc.nextInt(), sc.next(), orderMap);

						} else
							throw new AuthorizationException("Unauthorized operation");
						break;
					case 0:
						exit = true;
						break;
					default:
						System.out.println("Invalid choice do what ever u want");
					}

				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}
}
