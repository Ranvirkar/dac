package com.cd.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;

import com.cd.entites.Item;

public class ItemUtilities {

    public static void storingFile(String fileName, List<Item> items) throws FileNotFoundException, IOException {
        try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(fileName))) {
            ob.writeObject(items);
            System.out.println("Data stored successfully in file " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
            throw e;
        }
    }

    public static List<Item> readFile(String fileName)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ip = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Item>) ip.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            throw e;
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found when reading file: " + fileName);
            throw e;
        }
    }

    public static void addItems(String code, String descr, double price, LocalDate date, List<Item> itemList) {
        Item i = new Item(code, descr, price, date);

        for (Item item : itemList) {
            if (item.getItemcode().equals(i.getItemcode())) {
                System.out.println("Duplicate item code entry");
                return;
            }
        }

        itemList.add(i);
        System.out.println("Item has been successfully added: " + i);
    }
}
