package com.catalyst.hobbycollector.team1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.hobbycollector.team1.daos.CategoryDao;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.services.CategoryService;
/**
 * implements category services functions
 * @author ccrosby
 *
 */
@Service
/**
 * implements category services functions
 * @author ccrosby
 *
 */
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	/**
	 * @param categoryDao the categoryDao to set
	 */
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public List<Category> getCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	public void add(Category category) {
		categoryDao.add(category);
	}
	
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}
	
	@Override
	public Category getCategoryById(Integer categoryId) {
		return categoryDao.getByCategoryId(categoryId);
	}

}