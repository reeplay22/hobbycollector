package com.catalyst.hobbycollector.serviceImplTest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import org.junit.Before;
import org.junit.Test;
import org.junit.Before;

import com.catalyst.hobbycollector.team1.daos.CategoryDao;
import com.catalyst.hobbycollector.team1.entities.Category;
import com.catalyst.hobbycollector.team1.services.impl.CategoryServiceImpl;

public class CategoryServiceImplTest {

	private CategoryServiceImpl target;
	private CategoryDao mockCategoryDao;
	
	@Before
	public void setUp(){
		target = new CategoryServiceImpl();
		mockCategoryDao = mock(CategoryDao.class);
		target.setCategoryDao(mockCategoryDao);
	}
	
	@Test 
	public void testAdd() {
		target.add(null);
		verify(mockCategoryDao, times(1)).add(null);
	}
	
	@Test
	public void testUpdate() {
		target.update(null);
		verify(mockCategoryDao, times(1)).update(null);
	}
	
	private List<Category> categoryList(){
		List<Category> category = new ArrayList<>();
		Category c = new Category();
		category.add(c);
		return category;
	}
}
