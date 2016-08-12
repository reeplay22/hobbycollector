package com.catalyst.hobbycollector.daos.hibernateTest;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import org.junit.Before;
import org.junit.Test;

import com.catalyst.hobbycollector.team1.daos.hibernate.CategoryDaoHibernate;
import com.catalyst.hobbycollector.team1.entities.Category;
public class CategoryDaoHibernateTest {
	
	private CategoryDaoHibernate target;
	
	private EntityManager mockEm;
	
	@Before
	public void setUp() {
		target = new CategoryDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	@Test
	public void testAdd() {
		target.add(null);
		
		verify(mockEm, times(1)).persist(null);
	}
	
	@Test
	public void testGetAllCategories() {
		
		List<Category> expected = new ArrayList<>();
		
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		target.getAllCategories();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void getByCategoryId() {
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		
		target.getByCategoryId(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
	}
	
	@Test
	public void testUpdate() {
		Category expected = new Category();
		expected.setCategoryId(1);
		
		target.update(expected);
		
		verify(mockEm, times(1)).merge(expected);
	}
	
			
}
