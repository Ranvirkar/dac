package com.app.validaation;

import com.app.Entity.EmployeeEntity;

public class Comparator implements java.util.Comparator<EmployeeEntity> {

	@Override
	public int compare(EmployeeEntity d1, EmployeeEntity d2) {
		return d1.getJoiningDate().compareTo(d2.getJoiningDate());
	}
}
