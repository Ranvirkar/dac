package com.petstore.utils;

import java.util.Map;

import com.petstore.entities.Category;
import com.petstore.entities.Order;
import com.petstore.entities.Pet;
import com.petstore.entities.Status;
import com.petstore.exception.OutOfStockException;

public class PetStoreUtility {

	public static boolean userLogin(String username, String password, Map<String, String> userMap) {
		return userMap.containsKey(username) && userMap.get(username).equals(password);
	}
	
	public static boolean isLoggedIn(String login) {
		return login!=null;
	}

	public static String addPet(String name, String category, double price, int stock, Map<Integer, Pet> petMap) {
		Pet newpet = new Pet(name, Category.valueOf(category), price, stock);
		petMap.put(newpet.getPetid(), newpet);
		return "Pet has been added successfully";
	}

	public static String updatePetDetails(int petid, String name, String category, double price, int stock,
			Map<Integer, Pet> petMap) {
		Pet pet = petMap.get(petid);
		if (pet != null) {
			pet.setName(name);
			pet.setCategory(Category.valueOf(category));
			pet.setPrice(price);
			pet.setStock(stock);
			return "Pen details has been updated successfully";

		}
		return "Invalid Pet ID";
	}

	public static void displayAllpets(Map<Integer, Pet> petMap) {
		petMap.values().forEach(System.out::println);
	}

	public static String orderPet(int petid, int quantity, Map<Integer, Order> ordermap, Map<Integer, Pet> petMap)
			throws OutOfStockException {
		Pet pet = petMap.get(petid);
		if (pet != null) {
			if (pet.getStock()-quantity  <= 0)
				throw new OutOfStockException("Pet Out of Stock Remaining pet " + pet.getStock());

			Order newOrder = new Order(petid, quantity);
			ordermap.put(newOrder.getOrderId(), newOrder);
			pet.setStock(pet.getStock() - quantity);
			return "Order has been placed for " + newOrder;
		}
		return "Order has been failed due to invalid input";

	}

	public static void checkOrderStatus(int id, Map<Integer, Order> ordermap) {

		Order order = ordermap.get(id);
		if (order != null) {
			System.out.println("Current status of order is  " + order.getStatus());
			return;
		}
		System.out.println("Invalid order id failed to check status");

	}

	public static String updateOrderStatus(int id, String status, Map<Integer, Order> ordermap) {
		Order order = ordermap.get(id);
		if (order != null && order.getStatus() != Status.valueOf(status)) {
			order.setStatus(Status.valueOf(status));
			return "Updating order Status to " + order.getStatus();

		}
		return "Invalid Id or Status not updated due to same Status";
	}

}
