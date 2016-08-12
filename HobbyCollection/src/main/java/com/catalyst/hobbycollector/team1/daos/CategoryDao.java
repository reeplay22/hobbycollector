package com.catalyst.hobbycollector.team1.daos;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Category;
/**
 * category dao
 * 
 */
public interface CategoryDao {
	/**
	 * Add stolen item to collectable.
	 * @param category
	 */
	void add(Category category);
	

	/**
	 * Update or change information about a stolen item
	 * @param category
	 */
	void update(Category category);
	
	/**
	 * Return all Collectables that are currently stored.
	 * @param <Category> 
	 * @return <Category>
	 */
	List<Category> getAllCategories();
	
	/**
	 * Returns information regarding a specific category Id from storage with a matching Id.
	 * @param categoryId
	 * @return 
	 * 
	 */
	Category getByCategoryId(Integer categoryId);
}