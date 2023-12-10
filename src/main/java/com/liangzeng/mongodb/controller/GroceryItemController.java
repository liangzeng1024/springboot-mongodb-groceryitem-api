package com.liangzeng.mongodb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liangzeng.mongodb.exception.GroceryItemCollectionException;
import com.liangzeng.mongodb.model.GroceryItem;
import com.liangzeng.mongodb.service.GroceryItemService;

@RestController
public class GroceryItemController {
	
	@Autowired
	private GroceryItemService service;
	
	@GetMapping("/groceryitems")
	public ResponseEntity<?> getAllGroceryItems(){
		
		List<GroceryItem> items = service.getAllGroceryItems();
		
		return new ResponseEntity<>(items,items.size()> 0? HttpStatus.OK : HttpStatus.NOT_FOUND);
		
		
	}
	
	@PostMapping("/groceryitems")
	public ResponseEntity<?> createGroceryItem(@RequestBody GroceryItem item){
		try {
			service.createGroceryItem(item);
			return new ResponseEntity<GroceryItem>(item, HttpStatus.OK);				
			
		}catch(GroceryItemCollectionException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	@GetMapping("/groceryitems/{id}")
	public ResponseEntity<?> getGroceryItemById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(service.getGroceryItemById(id), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			
		} 
		
	}
	
	
	@PutMapping("/groceryitems/{id}")
	public ResponseEntity<?> updateGroceryItemById(@PathVariable("id") String id, @RequestBody GroceryItem item ){
		try {
			service.updateGroceryItemById(id, item);
			return new ResponseEntity<>("Update grocery item with " + id, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/groceryitems/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id){
		try {
			service.deleteGroceryItemById(id);
			return new ResponseEntity<>("Successfully deleted with id "+id, HttpStatus.OK);
			
		} catch(GroceryItemCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	

}
