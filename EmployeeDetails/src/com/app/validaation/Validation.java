package com.app.validaation;

import java.time.LocalDate;
import java.util.List;

import com.app.Entity.Application;
import com.app.Entity.EmployeeEntity;
import com.app.exception.EmployeeException;

public class Validation {

	//validate date of joining 
	public static EmployeeEntity checkValidation(Application fte, String name, String joiningDate, String phoneNum,
			String aadharNum, List<EmployeeEntity> list) throws EmployeeException {
		LocalDate date = LocalDate.parse(joiningDate);
		checkPhone(phoneNum);
		return new EmployeeEntity(fte, name, date, phoneNum, aadharNum);
	}
	
	//search employee

	public static EmployeeEntity searchEmp(int id, List<EmployeeEntity> list) throws EmployeeException {
		for (EmployeeEntity e : list) {
			if (e.getId() == id) {
				return e;
			}
		}
		throw new EmployeeException("employee not found");
	}
	
	
	//search by aadharNumber
	
	public static EmployeeEntity searchByAadhar(int aadharrNum, List<EmployeeEntity> list) throws EmployeeException {
		for (EmployeeEntity e : list) {
			if (e.getAadharNum().equals(aadharrNum)) {
				return e;
			}
		}
		throw new EmployeeException("employee not found");
	}
	
	
	//mobile number validation
	public static void checkPhone(String pnum) throws EmployeeException {
		String regex = "^[0-9]*$ ";
		if(!pnum.matches(regex) && pnum.length()!=10) {
			throw new EmployeeException("Phone number is not validate!!!");
		}
	}
	
	//aadhar number validation
	public static void chechAadhar(String aadhar)throws EmployeeException{
		String regex =  "^[0-9]\\S+$";
		if(!aadhar.matches(regex) && aadhar.length()!=12) {
			throw new EmployeeException("Aadhar number is not validate!!!");
		}
	}
	
	
}
