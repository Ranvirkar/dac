package com.swp.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.swp.entites.Pen;

public class PenUtility {

	public static Pen addNewPen(String brand, String color, String ink, String material, double price,
			Map<Integer, Pen> penMap) {

		return new Pen(brand, color, ink, material, price);
	}

	public static int updateStockProperties(String brand, String color, String ink, String material, double price,
			Map<Integer, Pen> penMap) {
		int quantity = 0;
		for (Pen pen : penMap.values()) {
			pen.setBrand(brand);
			pen.setColor(color);
			pen.setInkColor(ink);
			pen.setMaterial(material);
			pen.setPrice(price);
			pen.setUpdateDate(LocalDate.now());
			++quantity;
		}
		return quantity;
	}

	public static int discount3month(Map<Integer, Pen> penMap) {
		int cnt = 0;
		for (Pen p : penMap.values()) {
			Period period = Period.between(p.getListDate(), LocalDate.now());
			if (period.getMonths() == 3) {
				p.setDiscount(20);
				p.setPrice(p.getPrice() * 0.80);
				++cnt;
			}
		}
		return cnt;

	}

	public static int remove9month(Map<Integer, Pen> penMap) {
		int initSize = penMap.size();
		LocalDate nine = LocalDate.now().minusMonths(9);
		int cnt = 0;

		Iterator<Pen> iterator = penMap.values().iterator();

		while (iterator.hasNext()) {

			if (iterator.next().getListDate().isBefore(nine)) {
				iterator.remove();
				++cnt;
			}
		}
		return initSize - cnt;

	}

}
