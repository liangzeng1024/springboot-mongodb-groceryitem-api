package com.liangzeng.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.liangzeng.mongodb.model.GroceryItem;



@Repository
public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

	@Query("{'groceryitem':?0}")
	Optional<GroceryItem> findByGroceryItem(GroceryItem groceryItem);

	
	
}
