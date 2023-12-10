package com.liangzeng.mongodb.service;

import java.util.List;

import com.liangzeng.mongodb.exception.GroceryItemCollectionException;
import com.liangzeng.mongodb.model.GroceryItem;

public interface GroceryItemService {
	
	public void createGroceryItem(GroceryItem groceryItem)throws GroceryItemCollectionException;

	public List<GroceryItem> getAllGroceryItems();
	
	public GroceryItem getGroceryItemById(String id) throws GroceryItemCollectionException;
	
	public void updateGroceryItemById(String id,GroceryItem item) throws GroceryItemCollectionException;
	
	public void deleteGroceryItemById(String id) throws GroceryItemCollectionException ;
}
