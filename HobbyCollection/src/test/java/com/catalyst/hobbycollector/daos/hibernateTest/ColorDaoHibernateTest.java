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

import com.catalyst.hobbycollector.team1.daos.hibernate.ColorDaoHibernate;
import com.catalyst.hobbycollector.team1.entities.Color;

public class ColorDaoHibernateTest {
	
private ColorDaoHibernate target;
	
	private EntityManager mockEm;
	
	@Before
	public void setUp() {
		target = new ColorDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	@Test
	public void testAdd() {
		target.add(null);
		
		verify(mockEm, times(1)).persist(null);
	}
	
	@Test
	public void testGetAllColors() {
		
		List<Color> expected = new ArrayList<>();
		
		TypedQuery<Color> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(Color.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		target.getAllColors();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void getByColorId() {
		TypedQuery<Color> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(Color.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		
		target.getByColorId(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
	}
	
	@Test
	public void testUpdate() {
		Color expected = new Color();
		expected.setColorId(1);
		
		target.update(expected);
		
		verify(mockEm, times(1)).merge(expected);
	}
	
}