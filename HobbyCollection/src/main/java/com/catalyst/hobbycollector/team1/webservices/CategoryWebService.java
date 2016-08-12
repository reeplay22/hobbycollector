package com.catalyst.hobbycollector.team1.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.services.CategoryService;

/**
 * webservice for category
 * @author ccrosby
 *
 */
@RestController
public class CategoryWebService {
	@Autowired
	private CategoryService categoryService;	
	
	public void setCategoryDao(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * get all categories
	 * @return
	 */
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
	return categoryService.getCategories();
		
	}
	/**
	 * add a category
	 * @param category
	 */
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public void addCategory(@RequestBody Category category) {

		categoryService.add(category);
		
	}
	/**
	 * get category based on id
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public Category getCategoryByCategoryId(@PathVariable Integer categoryId)  {
		return categoryService.getCategoryById(categoryId);
	}
	/**
	 * update a category
	 * @param categoryId
	 * @param category
	 */
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.PUT)
	public void update(@PathVariable Integer categoryId,@RequestBody Category category) {
		categoryService.update(category);

	}
}
