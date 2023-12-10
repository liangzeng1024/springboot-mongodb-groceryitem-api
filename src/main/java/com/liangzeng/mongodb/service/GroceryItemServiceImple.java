package com.liangzeng.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.liangzeng.mongodb.exception.GroceryItemCollectionException;
import com.liangzeng.mongodb.model.GroceryItem;
import com.liangzeng.mongodb.repository.GroceryItemRepository;

@Service
public class GroceryItemServiceImple implements GroceryItemService {

	
	@Autowired
	private GroceryItemRepository itemRepo;
	
	public void createGroceryItem(GroceryItem groceryItem) throws GroceryItemCollectionException {
		
		Optional<GroceryItem> itemOptional = itemRepo.findByGroceryItem(groceryItem);
		if(itemOptional.isPresent()) {
			throw new GroceryItemCollectionException(GroceryItemCollectionException.GroceryItemAlreadyExists());
		}else {
			itemRepo.save(groceryItem);
		}
	}

	@Override
	public List<GroceryItem> getAllGroceryItems() {
		List<GroceryItem> items = itemRepo.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			return new ArrayList<GroceryItem>();
		}
	}

	@Override
	public GroceryItem getGroceryItemById(String id) throws GroceryItemCollectionException {
		
		Optional<GroceryItem> optionalItem = itemRepo.findById(id);
		if(! optionalItem.isPresent()) {
			throw new GroceryItemCollectionException(GroceryItemCollectionException.NotFoundException(id));
		} else {
			return optionalItem.get();
		}
			

	}

	@Override
	public void updateGroceryItemById(String id, GroceryItem item) throws GroceryItemCollectionException {
		Optional<GroceryItem> itemOptional = itemRepo.findById(id);
		if(itemOptional.isPresent()) {
			GroceryItem itemUpdate = itemOptional.get();
			itemUpdate.setName(item.getName());
			itemUpdate.setPrice(item.getPrice());
			itemUpdate.setQuantity(item.getQuantity());
			itemUpdate.setCategory(item.getCategory());
			itemRepo.save(itemUpdate);
		}else {
			throw new GroceryItemCollectionException(GroceryItemCollectionException.NotFoundException(id));
		}
	}

	@Override
	public void deleteGroceryItemById(String id) throws GroceryItemCollectionException {
		Optional<GroceryItem> itemOptional = itemRepo.findById(id);
		if(! itemOptional.isPresent()) {
			throw new GroceryItemCollectionException(GroceryItemCollectionException.NotFoundException(id));
		}else {
			itemRepo.deleteById(id);
		}
		
	}
	
}
