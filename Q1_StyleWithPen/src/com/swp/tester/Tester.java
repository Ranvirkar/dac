package com.swp.tester;

import static com.swp.utils.PenUtility.addNewPen;
import static com.swp.utils.PenUtility.discount3month;
import static com.swp.utils.PenUtility.remove9month;
import static com.swp.utils.PenUtility.updateStockProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.swp.entites.Pen;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			Map<Integer, Pen> penMap = new HashMap<>();
			boolean exit = false;

			while (!exit) {
				System.out.println("---------------Start---------------------");
				System.out.println("1)Add Pen");
				System.out.println("2)Update Stock");
				System.out.println("3)Discount of 20% for Pen Last 3 month");
				System.out.println("4)Remove Pen more than 9 months");
				System.out.println("5)Display All Pen");
				System.out.println("0)Exit the program");
				System.out.println("---------------End---------------------");

				System.out.println("\nEnter your choice Bruh Admin : ");

				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println("Adding New Pen to Stock");
						System.out.println("Enter Brand , Color , Ink-Color , Material , " + "Price ");
						Pen newPen = addNewPen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), penMap);
						penMap.put(newPen.getId(), newPen);
						System.out.println("New Pen has been successfully added : \n" + newPen);
						break;
					case 2:
						System.out.println("Updating the Stock");
						System.out.println("Enter Pen id");
						if (penMap.get(sc.nextInt()) != null) {
							System.out.println("Enter Brand , Color , Ink-Color , Material , " + "Price ");
							int count = updateStockProperties(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
									penMap);
							System.out.println("Stock Updated Successfully count" + count);
						} else {
							System.out.println("Invalid Pen ID");
						}

						break;
					case 3:
						System.out.println("Discount on Pen more than 3 month");
						System.out.println("Number of Pens Updated Disount more than 3 month \n : "+discount3month(penMap));
						break;
					case 4:
						System.out.println("Removing old pen more than 9 month");
						System.out.println("Number of Pens Removed "+remove9month(penMap));
						break;
					case 5 : System.out.println("Displaying Stock of Pen");
						penMap.forEach((Integer,Pen)->System.out.println(Pen));
							break;
					case 0:
						System.out.println("Exiting the Program Sire Pratik");
						exit = true;

					}

				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}

		}

	}

}
