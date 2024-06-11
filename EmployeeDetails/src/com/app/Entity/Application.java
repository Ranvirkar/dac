package com.app.Entity;

public enum Application {

	FTE(30000), PTE(1000);

	 private final int value;

	    Application(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

}
