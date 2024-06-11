package com.app.Entity;

import java.time.LocalDate;

public class EmployeeEntity {

	private int id;
	private Application type;
	private String name;
	private LocalDate joiningDate;
	private String phoneNum;
	private String aadharNum;
	private static int count;
	
	


	public EmployeeEntity( Application type, String name, LocalDate joiningDate, String phoneNum, String aadharNum) {
		super();
		this.id = ++count;
		this.type = type;
		this.name = name;
		this.joiningDate = joiningDate;
		this.phoneNum = phoneNum;
		this.aadharNum = aadharNum;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", joiningDate=" + joiningDate +", Job Type="+type+ ", phoneNum=" + phoneNum
				+ ", aadharNum=" + aadharNum + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAadharNum() {
		return aadharNum;
	}


	public void setAadharNum(String aadharNum) {
		this.aadharNum = aadharNum;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
	
	
	
	
}
