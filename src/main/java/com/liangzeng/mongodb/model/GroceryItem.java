package com.liangzeng.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="groceryitems")
public class GroceryItem {
	
	@Id
	private String id;
	
	@NotNull(message = "Grocery item can not be null")
	private String name;
	
	@NotNull(message = "Price can not be null")
	private double price; 
	
	@NotNull(message = "Quantity can not be null")
	private int quantity;
	
	@NotNull(message = "Grocery category can not be null")
	private String category;
	

}
