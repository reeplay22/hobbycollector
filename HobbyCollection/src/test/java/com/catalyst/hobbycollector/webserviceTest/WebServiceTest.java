package com.catalyst.hobbycollector.webserviceTest;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.services.CategoryService;
import com.catalyst.hobbycollector.team1.webservices.CategoryWebService;



public class WebServiceTest {
	private CategoryService mockCategoryService;
	private CategoryWebService categoryWebService;
	
	@Before
	public void createCategoryWebService() throws Exception {
		mockCategoryService = mock(CategoryService.class);
		categoryWebService = new CategoryWebService();
		categoryWebService.setCategoryDao(mockCategoryService);

	}
	
	@Test
	public void testAddCategory() throws Exception {
		categoryWebService.addCategory(null);
		verify(mockCategoryService, times(1)).add(null);
	}
	
	@Test
	public void testGetCategory() throws Exception {
		categoryWebService.getAllCategories();
		verify(mockCategoryService, times(1)).getCategories();
	}

}