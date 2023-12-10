package com.liangzeng.mongodb.exception;

public class GroceryItemCollectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public GroceryItemCollectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public static String NotFoundException(String id) {
		return "Grocery with " + id + "not found";
	}
	
	public static String GroceryItemAlreadyExists() {
		return "Grocery item with given name already exists.";
	}
	
	

}
