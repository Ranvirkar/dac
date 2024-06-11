package com.cd.tester;

import static com.cd.utility.ItemUtilities.addItems;
import static com.cd.utility.ItemUtilities.readFile;
import static com.cd.utility.ItemUtilities.storingFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.cd.entites.Item;

public class ItemTester {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        boolean exit = false;

        try (Scanner sc = new Scanner(System.in)) {

            while (!exit) {
                System.out.println("1) Add Items");
                System.out.println("2) Storing Items");
                System.out.println("3) Sort them as per item code");
                System.out.println("4) Sort them as per price");
                System.out.println("5) Store them inside file");
                System.out.println("6) Reading from File");
                System.out.println("0) Exit");

                System.out.println("Enter your choice: ");
                try {
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter code, description, price, ship date (YYYY-MM-DD): ");
                            addItems(sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()), items);
                            break;
                        case 2:
                            System.out.println("Enter filename to store: ");
                            storingFile(sc.next(), items);
                            break;
                        case 3:
                            System.out.println("Sorting them as per item code");
                            items.sort((a, b) -> a.getItemcode().compareTo(b.getItemcode()));
                            items.forEach(System.out::println);
                            break;
                        case 4:
                            System.out.println("Sorting as per price");
                            items.sort((a, b) -> (((Double)a.getPrice()).compareTo(b.getPrice())));
                            items.forEach(System.out::println);
                            break;
                        case 5:
                            System.out.println("Enter filename to store: ");
                            storingFile(sc.next(), items);
                            break;
                        case 6:
                            System.out.println("Enter filename to read: ");
                            List<Item> itm = readFile(sc.next());
                            for (Item item : itm) {
                                System.out.println(item);
                            }
                            System.out.println("Read data successfully");
                            break;
                        case 0:
                            System.out.println("Exiting");
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    sc.next(); // Clear the invalid input
                }
            }

        }
    }
}
