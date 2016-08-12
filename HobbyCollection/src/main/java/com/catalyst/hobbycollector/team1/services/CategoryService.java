package com.catalyst.hobbycollector.team1.services;

import java.util.List;

import com.catalyst.hobbycollector.team1.entities.Category;
/**
 * category service functions
 * @author ccrosby
 *
 */
public interface CategoryService {
	
	/**
	 * Adds new item to category
	 * @param category
	 * @return
	 */
	void add(Category category);
	
	/**
	 * Retrieves all items from category
	 * @return
	 */
	List<Category> getCategories();
	
	/**
	 * Update information on existing category.
	 * @param category
	 */
	
	void update(Category category);
	
	/**
	 * Retrieves category information
	 * @param categoryId
	 * @return
	 */
	Category getCategoryById(Integer categoryId);
	
}
