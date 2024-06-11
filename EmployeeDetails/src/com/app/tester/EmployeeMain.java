package com.app.tester;

import static com.app.validaation.Validation.checkValidation;
import static com.app.validaation.Validation.searchByAadhar;
import static com.app.validaation.Validation.searchEmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.Entity.Application;
import com.app.Entity.EmployeeEntity;
import com.app.validaation.Comparator;

public class EmployeeMain {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			boolean exit = false;
			List<EmployeeEntity> list = new ArrayList<>();
			while (!exit) {
				System.out.println("MENU :");
				System.out.println("1.Add full time employee\r\n" + "2.Add part time employee\r\n"
						+ "3.Delete an employee by Emp Id\r\n" + "4.Search employee details by Aadhaar number\r\n"
						+ "5.Display all employee details\r\n"
						+ "6.Display all employee details sorted by date of joining\r\n" + "0.Exit\r\n");

				int choice = scan.nextInt();
				try {
					switch (choice) {
					case 1:
//					int id, Application type, String name, LocalDate joiningDate, Int phoneNum, Int aadharNum

						System.out.println("1.name 2.joiningDate 3.phoneNumber 4.aadharNumber");
						EmployeeEntity e = checkValidation(Application.FTE, scan.next(), scan.next(), scan.next(),
								scan.next(), list);
						list.add(e);
						System.out.println("employee added");
						break;
						
					case 2:
						System.out.println("1.name 2.joiningDate 3.phoneNumber 4.aadharNumber");
						e = checkValidation(Application.PTE, scan.next(), scan.next(), scan.next(), scan.next(),
								list);
						list.add(e);
						System.out.println("employee added");
						break;

					case 3:
						System.out.println("enter employee ID :");
						e = searchEmp(scan.nextInt(), list);
						list.remove(e);
						System.out.println("employee data deleted");
						break;

					case 4:
						System.out.println("enter aadhar number : ");
						e = searchByAadhar(scan.nextInt(), list);
						System.out.println("employee found :");
						System.out.println(e);

						break;

					case 5:
						System.out.println("list of all employee as per joining date: ");
						list.stream().forEach(l -> System.out.println(l));
						break;

					case 6:
						Comparator c = new Comparator();
						Collections.sort(list, c);
						list.stream().forEach(l -> System.out.println(l));
						break;

					case 0:
						System.out.println("Exit from Application");
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}

}
